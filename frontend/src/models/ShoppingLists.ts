import React from "react";
import {IItem} from "./ShoppingItems";

export type removeListFunc = (listName: string) => void

export interface IList {
    id: string,
    listName: string,
    items: IItem[]
}

export type IListSetter = React.Dispatch<React.SetStateAction<IList[]>>

export interface IListController {
    getLists: () => Promise<IList[]> | void
    addList: (listName: string) => Promise<IList[]> | void
    removeList: (listName: string) => Promise<IList[]> | void
}