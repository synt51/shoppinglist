import Lists from "../components/Lists";
import React, {ChangeEvent, FormEvent, useEffect, useState} from "react";
import '../App.scss';
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faPlus, faTrash} from "@fortawesome/free-solid-svg-icons";
import {IItemController} from "../controller/itemController";
import {IItem, IItems} from "../models/ShoppingItems";
import {TextField} from "@mui/material";
import {IListController} from "../controller/listController";
import {IList, ILists} from "../models/ShoppingLists";



export default function Home(props: { controller: IListController }) {
    const {controller} = props
    const [lists, setLists] = useState<Promise<ILists[]>>(() => {
        console.log("Lists")
        return controller.getLists()
    })


    useEffect(() => {
        getAllLists()
            .then(lists => setLists(lists))
            .catch(error => console.error(error))
    }, [])

    const createNewList = listName =>
        postList(listName)
            .then(() => getAllLists())
            .then(lists => setLists(lists))
            .catch(error => console.error(error))

    const removeList = listId =>
        deleteList(listId)
            .then(() => getAllLists())
            .then(lists => setLists(lists))
            .catch(error => console.error(error))

    const editListName = list =>
        putListName(list)
            .then(() => getAllLists())
            .then(lists => setLists(lists))
            .catch(error => console.error(error))

    return (
        <div className={"App-header"}>
            <h1>Shopping Lists</h1>
            <div className={"AddListBox"}>
                <form onSubmit={createNewList}>
                    <input className={"AddListText"} type={"textarea"} placeholder={"New list name..."} maxLength={25}
                           id={"textInput"}/>
                    <button type={"submit"}/>
                    <FontAwesomeIcon icon={faPlus}/>
                </form>
            </div>
            <div className={"Outer"}>
                <div className={"Inner"}>
                    <Lists lists={lists} edit={editListName} remove={removeList} />
                </div>
            </div>
        </div>
    )
}