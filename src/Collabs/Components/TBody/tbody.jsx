import React, {useState, useEffect} from 'react';

import './tbody.css';
import {BsPencil} from "react-icons/bs";
import {FiTrash2} from "react-icons/fi";
import {IoStatsChart} from "react-icons/io5";
import {useHistory} from "react-router-dom";


const API_URL = 'http://localhost:8080/getCollabs'

const Tbody = () => {
    const [collabs, setCollabs] = useState([]);
    const [collabsExists, setCollabsExists] = useState(false);
    const [searchTerm, setSearchTerm] = useState([]);

    useEffect(() => {
        if (collabsExists === false) {
            searchCollabs("");
        }
    })
    const searchCollabs = async (title) => {
        const response = await fetch('http://localhost:8080/getCollabs')
        const data = await response.json()
        console.log(data);
        setCollabsExists(true);
        setCollabs(data);
    }
    const history = useHistory();
    const sendToAdd = (collaborateur) => {
        history.push("/add", {collaborateur: collaborateur.matricule})
    }


    return (
        collabs.map((collab) => {
                return (<div className="tlrh__list-tbody">
                    <p style={{padding: "0 0 0 10px", fontWeight: "bold"}}>{collab.matricule}</p>
                    <div className="tlrh__list-tbody_td">
                        <p>{collab.nom} {collab.prenom}</p>
                        <p>{collab.nouveauRH}</p>
                        <p>{collab.site}</p>
                        <p>{collab.bu}</p>
                        <p>{collab.embauche}</p>
                        <p>{collab.depart}</p>
                        <p>{collab.poste}</p>
                        <p>{collab.salaire}</p>
                    </div>
                    <div className="tlrh__list-tbody_icons">
                        <IoStatsChart size="25px"/>
                        <BsPencil onClick={() => {sendToAdd(collab)}} size="25px"/>
                        <FiTrash2 size="25px"/>
                    </div>
                </div>)
            }
        )
    )
}
export default Tbody
