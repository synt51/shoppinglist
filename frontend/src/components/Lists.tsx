import {IList, removeListFunc} from "../models/ShoppingLists";
import ListCard from "./ListCard";


// const mapListToCards: (list: IList,  index: number, remove: removeListsFunc) => JSX.Element =
//     (list, index, remove,) => {
//     return <ListCard list={list} key={index} remove={remove}/>
//     }

export default function Lists(props: { lists: IList[], removeList: removeListFunc}){
    if (props.lists == null) return null;
    return (
        <>
            {
                props.lists.map((list, index) =>
                    <ListCard list={list} remove={props.removeList} key={index}/>)
            }
        </>
    )
}