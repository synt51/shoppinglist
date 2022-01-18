import React, {FormEvent, useState} from "react";
import '../App.scss';
import './Lists.scss';
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faPlus, faTrash} from "@fortawesome/free-solid-svg-icons";
import {IItem} from "../models/ShoppingItems";
import {IListController} from "../controller/listController";
import {TextField} from "@mui/material";
import Items from "../components/Items";
import {IItemController} from "../controller/itemController";




export default function ListPage(props: {listController: IItemController}) {


    return (
        <div className={"App-header"}>
            <h1>List:</h1>
            <div className={"AddItemBox"}>
                <form onSubmit={addItem}>
                    <TextField className={"AddItemQuantity"} label={"QTY"}  type={"number"} inputProps={{ style: { textAlign: 'center' }}}
                               size= 'small' margin= 'none' onChange={handleQuantity} value={quantityStatus} id={"outlined-number"} InputLabelProps={{
                        shrink: true,
                    }}/>
                    <input className={"AddItemText"} type={"textarea"} placeholder={"Add an item..."} maxLength={15} id={"textInput"}/>
                    <button  type={"submit"}/>
                    <FontAwesomeIcon icon={faPlus}/>
                </form>
            </div>
            <div className={"DeleteList"}>
                <p> Delete everything?</p>
                <button className={"trash"}>
                    <FontAwesomeIcon icon={faTrash} onClick={() => {
                        removeAll()
                    }}/>
                </button>
            </div>
            <div className={"Outer"}>
                <div className={"Inner"}>
                    <Items items={items} add={addItem} remove={removeItem} decrease={decreaseItem} />
                </div>
            </div>
        </div>
    )
}