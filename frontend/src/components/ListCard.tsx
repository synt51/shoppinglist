import {IList, removeListFunc} from "../models/ShoppingLists";

import {Link} from "react-router-dom";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faExchangeAlt, faTrash} from "@fortawesome/free-solid-svg-icons";


export interface ListCardProps {
    list: IList
    remove: removeListFunc
}

export default function ListCard(props: ListCardProps){
    const {list, remove} = props
    const name: string = list.listName
    const id: string = list.id

    return (
        <div className={"List"}>
             <h2>{name}</h2>
            <div className={"ListActions"}>
                <button className={"trash"}>
                    <FontAwesomeIcon icon={faTrash} onClick={() => {
                        remove(name)
                    }}/>
                </button>
            </div>
        </div>
    )
}