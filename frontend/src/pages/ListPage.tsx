import React, {ChangeEvent, FormEvent, useEffect, useState} from "react";
import '../App.scss';
import './Lists.scss';
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faPlus, faTrash} from "@fortawesome/free-solid-svg-icons";
import {IItem, IItemController} from "../models/ShoppingItems";
import {TextField} from "@mui/material";
import Items from "../components/Items";
import {useNavigate, useParams} from "react-router-dom";


interface ITextInput {
    quantityInput: { value: string }
    textInput: { value: string }
}

export default function ListPage(props: { controller: IItemController, items: IItem[] }) {

    const {controller, items} = props
    // const [items, setItems] = useState<IItem[]>([])
    const params = useParams()
    const listName: string = params.name!
    const navigate = useNavigate()
    const [quantityState, setQuantityState] = useState<number>(1)

    useEffect(() => {
        // axios.get('http://localhost:5000/api/lists').then(response => setLists(response.data));
        controller.getItems(listName)
    }, [])

    function instanceOfIItem(object: any): object is IItem {
        return 'itemName' in object
    }

    const addItem = (event: FormEvent<HTMLFormElement> | IItem) => {
        // Jump in when button "Add" is being pressed
        if (instanceOfIItem(event)) {
            controller.addItem(listName, event.itemName, 1)
            // Jump in when Item is being added via form
        } else {
            event.preventDefault()
            const form = event.currentTarget
            const formElements = form.elements as typeof form.elements & ITextInput
            const textInputValue: string = formElements.textInput.value
            // const quantityInputValue: number = formElements.quantityInput.value as unknown as number
            textInputValue.length > 15 ?
                alert("Maximum 15 characters allowed") :
                controller.addItem(listName, textInputValue, quantityState)
            // @ts-ignore
            event.currentTarget.elements.textInput.value = ""
        }
    }

    const removeItem = (itemID: string, wholeItem: boolean) => {
        controller.removeItem(listName, itemID, wholeItem)
    }

    const changeItem = (itemName: string) => {
        navigate(`/changeItem/${listName}/${itemName}`)
    }

    const handleQuantity = (event: ChangeEvent) => {
        event.preventDefault()
        const re = /^[0-9]+$/g
        // @ts-ignore
        setQuantityState(re.test(event.target.value) ? event.target.value : quantityState)
    }

    return (
        <div className={"App-header"}>
            <h1>List:</h1>
            <div className={"AddItemBox"}>
                <form onSubmit={addItem}>
                    <TextField className={"AddItemQuantity"} label={"QTY"}  type={"number"} inputProps={{ style: { textAlign: 'center' }}}
                               size= 'small' margin= 'none' onChange={handleQuantity} value={quantityState} id={"outlined-number"} InputLabelProps={{
                        shrink: true,
                    }}/>
                    <input className={"AddItemText"} type={"textarea"} placeholder={"Add an item..."} maxLength={15} id={"textInput"}/>
                    <button  type={"submit"}/>
                    <FontAwesomeIcon icon={faPlus}/>
                </form>
            </div>
            <div className={"DeleteList"}>
                <p> Delete everything?</p>
                <button className={"trash"}>
                    <FontAwesomeIcon icon={faTrash} onClick={() => {
                        //removeAll()
                    }}/>
                </button>
            </div>
            <div className={"Outer"}>
                <div className={"Inner"}>
                    <Items items={items} add={addItem} remove={removeItem} change={changeItem} />
                </div>
            </div>
        </div>
    )
}