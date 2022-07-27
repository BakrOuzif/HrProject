import React from 'react';

import './list.css';
import {Tbody} from '../../Components'
import {FiFilter} from 'react-icons/fi'
import {Link} from 'react-router-dom'
const List = () => {
    return (
        <div className="tlrh__list">
            <div className="tlrh__list_header">
                <h2>Liste Collaborateurs</h2>
                <div className="tlrh__list_header-right">
                    <FiFilter size="25px"/>
                    <button> <Link to={"/add"}>Ajouter Collaborateur</Link></button>
                </div>
            </div>
            <hr/>
            <div className="tlrh__list-thead">
                <p>Nom&Prenom</p>
                <p>Manager RH</p>
                <p>Site</p>
                <p>BU</p>
                <p>Date Embauche</p>
                <p>Date Départ</p>
                <p>Poste</p>
                <p>Salaire</p>
            </div>
            <Tbody/>
        </div>
    )
}
export default List