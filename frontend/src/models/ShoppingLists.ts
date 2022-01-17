import {IItem} from "./ShoppingItems";
import {FormEvent} from "react";


export type ILists = [n: string]
export type addListsFunc = (event: FormEvent<HTMLFormElement> | IList) => void
export type removeListsFunc = (list: IList) => void


export interface IList {
    id: string,
    listName: string,
    items: IItem[];
}

export type IListSetter = React.Dispatch<React.SetStateAction<IList[]>>

export interface ListsProps {
    lists: ILists,
    add: addListsFunc,
    remove: removeListsFunc
}