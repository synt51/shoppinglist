import {FormEvent} from "react";


export const STORAGE_KEY: string = 'shoppinglist'

export interface IItem {
    itemName: string,
    itemCount: number
}

export interface IItems {
    items: IItem[]
}

export type addItemsFunc = (event: FormEvent<HTMLFormElement> | IItem) => void
export type removeItemsFunc = (item: IItem) => void
export type decreaseItemsFunc = (item: IItem) => void

export type IItemSetter= React.Dispatch<React.SetStateAction<IItem[]>>

export interface ItemsProps {
    items: IItem[],
    add: addItemsFunc,
    remove: removeItemsFunc,
    decrease: decreaseItemsFunc
}


