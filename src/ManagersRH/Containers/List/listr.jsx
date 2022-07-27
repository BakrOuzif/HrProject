import React from 'react';

import './list.css';
import {Tbody} from '../../Components'
import {FiFilter} from 'react-icons/fi'
import {Link} from 'react-router-dom'


const ListR = (props) => {

    return (
        <div className="tlrh__list">
            <div className="tlrh__list_header">
                {props.id === 1 ? <h2>Liste Collaborateurs Non Managers</h2>: <h2>Liste Managers</h2>}
                <div className="tlrh__list_header-right">
                    <FiFilter size="25px"/>
                </div>
            </div>
            <hr/>
            <div className="tlrh__list-thead">
                <p>Nom&Prenom</p>
                <p>Site</p>
                <p>Poste</p>
                <p>Manager Actuel</p>
            </div>
            <Tbody id={props.id}/>
        </div>
    )
}
export default ListR