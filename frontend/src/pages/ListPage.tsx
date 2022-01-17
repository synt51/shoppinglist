import {FormEvent, useState} from "react";
import '../App.scss';
import './Lists.scss';
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faPlus} from "@fortawesome/free-solid-svg-icons";
import {IItem} from "../models/ShoppingItems";
import {IListController} from "../controller/listController";




export default function ListPage(props: {listController: IListController}) {
    const {listController} = props
    //const [lists, setLists] = useState<ILists>(controller.getLists())

    const addList = (event: FormEvent<HTMLFormElement> | IItem) => {

    }

    return (
        <div className={"App-header"}>
            <h1>Lists:</h1>
            <div className={"AddListBox"}>
                <form onSubmit={addList}>
                    <input className={"AddListText"} type={"textarea"} placeholder={"New list name..."} maxLength={25}
                           id={"textInput"}/>
                    <button type={"submit"}/>
                    <FontAwesomeIcon icon={faPlus}/>
                </form>
            </div>
            <section className={"lists"}>
                <article className={"lists-card"}>
                    <header className={"card-header"}>
                        <h2>XY's List</h2>
                        <p>Items inside: 9</p>
                    </header>
                </article>
                <article className={"lists-card"}>
                    <header className={"card-header"}>
                        <h2>XY's List</h2>
                        <p>Items inside: 9</p>
                    </header>
                </article>
                <article className={"lists-card"}>
                    <header className={"card-header"}>
                        <h2>XY's List</h2>
                        <p>Items inside: 9</p>
                    </header>
                </article>
                <article className={"lists-card"}>
                    <header className={"card-header"}>
                        <h2>XY's List</h2>
                        <p>Items inside: 9</p>
                    </header>
                </article>
            </section>
        </div>
    )
}