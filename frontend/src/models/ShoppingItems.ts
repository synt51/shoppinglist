import React, {FormEvent} from "react";

// export const STORAGE_KEY: string = process.env.NODE_ENV
export const apiURL: string = process.env.NODE_ENV === "development" ? "http://localhost:5000/api" : "/api"

// export type IItem = [string, number]
export interface IItem {
    id?: string,
    itemName: string,
    itemCount: number
}

export type addItemsFunc = (event: FormEvent<HTMLFormElement> | IItem) => void
export type removeItemsFunc = (itemID: string, wholeItem: boolean) => void
export type changeItemFunc = (itemName: string) => void

export interface ItemsProps {
    items: IItem[],
    add: addItemsFunc,
    remove: removeItemsFunc,
    change: changeItemFunc
}

export interface IItemController {
    getItems: (listName: string) => Promise<IItem[]> | void,
    addItem: (listName: string, newItem: string, quantity: number) => Promise<IItem[]> | void,
    removeItem: (listName: string, itemID: string, wholeItem: boolean) => Promise<IItem[]> | void,
    changeItem: (listName: string, itemID: string, newName: string) => Promise<IItem[]> | void
}

export type IItemSetter = React.Dispatch<React.SetStateAction<IItem[]>>