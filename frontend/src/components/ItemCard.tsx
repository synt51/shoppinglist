import {Link} from "react-router-dom";
import {addItemsFunc, changeItemFunc, IItem, removeItemsFunc} from "../models/ShoppingItems";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faChevronLeft, faChevronRight, faExchangeAlt, faTrash} from "@fortawesome/free-solid-svg-icons";

interface ItemCardProps {
    item: IItem
    add: addItemsFunc
    remove: removeItemsFunc
    change: changeItemFunc
}

export default function ItemCard(props: ItemCardProps) {
    const {item, add, remove, change} = props
    const name = `${item.itemName}`
    const count = `${item.itemCount}`
    return (
        <div className={"Item"}>
            <h2>{name}</h2>
            <div className={"ItemActions"}>
                <div className='quantity'>
                <button className={"arrow"} value={"Remove"}>
                    <FontAwesomeIcon icon={faChevronLeft} onClick={() => {
                        remove(item.id!, false)
                    }}/>
                </button>
                <span> {count} </span>
                <button className={"arrow"} value={"Add"}>
                    <FontAwesomeIcon icon={faChevronRight} onClick={() => {
                        add(item)
                    }}/>
                </button>
                </div>
                <Link to={`/change/${item.itemName}`}>
                    <button className={"change"}>
                        <FontAwesomeIcon icon={faExchangeAlt} onClick={() => {
                            change(item.id!)
                        }}/>

                    </button>
                </Link>
                <button className={"trash"}>
                    <FontAwesomeIcon icon={faTrash} onClick={() => {
                        remove(item.id!, true)
                    }}/>
                </button>
            </div>
        </div>
    );
}