import Lists from "../components/Lists";
import React, {ChangeEvent, FormEvent, FormEventHandler, useEffect, useState} from "react";
import '../App.scss';
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faPlus, faTrash} from "@fortawesome/free-solid-svg-icons";
import {IList, IListController} from "../models/ShoppingLists";




export default function Home(props: { controller: IListController, lists: IList[] }) {
    const {controller, lists} = props

    useEffect(() => {
        controller.getLists()
    }, [])

    const addNewList: FormEventHandler<HTMLFormElement> = (event) => {
        event.preventDefault()
        console.log(event)
        // @ts-ignore
        controller.addList(event.currentTarget.elements[0].value);
        // @ts-ignore
        event.currentTarget.elements[0].value = ""
        console.log("Add-List: ", lists)
    }

    const removeList = (listName: string) => {
        controller.removeList(listName)
    }

    const editListName = () => {}

    return (
        <div className={"App-header"}>
            <h1>Shopping Lists</h1>
            <div className={"AddListBox"}>
                <form onSubmit={addNewList}>
                    <input className={"AddListText"} type={"textarea"} placeholder={"New list name..."} maxLength={25}
                           id={"textInput"}/>
                    <button type={"submit"}/>
                    <FontAwesomeIcon icon={faPlus}/>
                </form>
            </div>
            <div className={"Outer"}>
                <div className={"Inner"}>
                    <Lists lists={lists} removeList={removeList}/>
                </div>
            </div>
        </div>
    )
}