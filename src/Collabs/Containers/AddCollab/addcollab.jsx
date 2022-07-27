import React, {useEffect, useRef, useState} from 'react';

import {AiOutlinePlus} from 'react-icons/ai'
import './addcollab.css';

const AddCollab = () => {
    const [isActive, setActive] = useState(0);
    const [collab, setCollab] = useState({
        nom: '',
        prenom: '',
        ancienRH: '',
        nouveauRH: '',
        site: '',
        sexe: '',
        salaire: '',
        bu: '',
        embauche: '',
        seminaire: '',
        dateSeminaire: '',
        poste: '',
        posteAPP: ''
    })
    const [diplome, setDiplome] = useState([])
    const [competence, setCompetence] = useState([])
    const handleChangeCollab = e => {
        setCollab(oldValues => ({
            ...oldValues,
            [e.target.name]: e.target.value,
        }));
    }
    const onClick = () => {
        setDiplome([])
        const inputs = document.querySelectorAll(".tlrh__adding_content-diplomes-divs input");
        let diplomes;
        diplomes = []
        let dip = {};
        for (let i = 0; i < inputs.length; i = i + 5) {
            if (inputs[i].value === '' && inputs[i + 1].value === '' && inputs[i + 2].value === '' && inputs[i + 3].value === '' && inputs[i + 4].value === ''){
                console.log("im here")
                continue
            }
            dip["diplome"] = inputs[i].value
            dip["typeDiplome"] = inputs[i + 1].value
            dip["ecole"] = inputs[i + 2].value
            dip["typeEcole"] = inputs[i + 3].value
            dip["promotion"] = inputs[i + 4].value
            diplomes.push(dip);
            dip = {}
        }
        setDiplome(prevState => [...prevState, ...diplomes]);
    }

    const onSubmit = (e) => {
        e.preventDefault()
        setCompetence([])
        const form = e.target;
        let competences = [];
        let comp = {};
        console.log(form.elements.competence)
        if(form.elements.competence.length === undefined){
            comp["name"] = form.elements.competence.value
            comp["note"] = form.note.value
            competences.push(comp);
        }else{
            for (let i = 0; i < form.elements.competence.length; i++) {
                comp["name"] = form.elements.competence[i].value
                comp["note"] = form.note[i].value
                competences.push(comp);
                comp = {}
            }
        }
        console.log(competences)
        setCompetence(prevState => [...prevState, ...competences]);

        const requestOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                "collab": collab,
                "competences": competences,
                "diplomes": diplome
            })
        };
        fetch('http://localhost:8080/saveCollab', requestOptions)
            .then(response => response.json())
            .then(data => console.log(data));
    }
    return (
        <div className="tlrh__adding">
            <div className="tlrh__adding_header">
                <h2>Ajouter Collaborateur</h2>
            </div>
            <hr/>
            <form onSubmit={onSubmit}>
                <div className="tlrh__adding_sections">
                    {
                        isActive === 0 &&
                        <section className="tlrh__adding_content">
                            <div className="tlrh__adding_content-head">
                                <h3>Information Personnel</h3>
                                <p>Veuillez remplir les informations personnelles du collaborateur</p>
                            </div>
                            <hr/>
                            <div className="tlrh__adding_content-container">
                                <div>
                                    <label htmlFor="nom">First Name</label>
                                    <input type="text" name="nom" id="nom" value={collab.nom}
                                           onChange={handleChangeCollab}
                                           placeholder="First Name"/>
                                </div>
                                <div>
                                    <label htmlFor="prenom">Last Name</label>
                                    <input type="text" name="prenom" id="prenom" value={collab.prenom}
                                           onChange={handleChangeCollab} placeholder="Last Name"/>
                                </div>
                                <div>
                                    <label htmlFor="nouveauRH">Last Manager</label>
                                    <input type="text" name="nouveauRH" id="nouveauRH" value={collab.nouveauRH}
                                           onChange={handleChangeCollab} placeholder="Last Manager"/>
                                </div>
                                <div>
                                    <label htmlFor="site">Site</label>
                                    <input type="text" name="site" id="site" value={collab.site}
                                           onChange={handleChangeCollab} placeholder="Site"/>
                                </div>
                                <div>
                                    <label htmlFor="sexe">Sexe</label>
                                    <select name="sexe" id="sexe"  placeholder="Sexe">
                                        <option defaultValue value="Homme">Homme </option>
                                        <option value="Femme">Femme </option>
                                        <option value="autre">Pas Précisé </option>
                                    </select>
                                </div>
                                <div>
                                    <label htmlFor="salaire">Salaire</label>
                                    <input type="text" name="salaire" id="salaire" value={collab.salaire}
                                           onChange={handleChangeCollab} placeholder="Salaire"/>
                                </div>
                                <div>
                                    <label htmlFor="bu">BU</label>
                                    <input type="text" name="bu" id="bu" value={collab.bu} onChange={handleChangeCollab}
                                           placeholder="BU"/>
                                </div>
                                <div>
                                    <label htmlFor="embauche">Date Embauche</label>
                                    <input type="date" name="embauche" id="embauche" value={collab.embauche}
                                           onChange={handleChangeCollab}/>
                                </div>
                                <div>
                                    <label htmlFor="seminaire">Participe au Séminaire</label>
                                    <select name="seminaire" id="seminaire"  placeholder="V ou F">
                                        <option defaultValue value="1">Vrai </option>
                                        <option value="0">Faux </option>
                                    </select>
                                </div>
                                <div>
                                    <label htmlFor="dateSeminaire">Date de participation</label>
                                    <input type="date" name="dateSeminaire" id="dateSeminaire"
                                           value={collab.dateSeminaire}
                                           onChange={handleChangeCollab}/>
                                </div>
                                <div>
                                    <label htmlFor="poste">Poste APP</label>
                                    <input type="text" name="poste" id="poste" value={collab.poste}
                                           onChange={handleChangeCollab} placeholder="Poste APP"/>
                                </div>
                                <div>
                                    <label htmlFor="posteAPP">Poste Actuel</label>
                                    <input type="text" name="posteAPP" id="posteAPP" value={collab.posteAPP}
                                           onChange={handleChangeCollab} placeholder="Poste Actuel"/>
                                </div>
                            </div>
                            <button className="tlrh__adding_content-buttonNext" onClick={() => setActive(1)}>Next
                            </button>
                        </section>
                    }
                    {
                        isActive === 1 &&
                        <section className="tlrh__adding_content">
                            <div className="tlrh__adding_content-head">
                                <h3>Diplomes</h3>
                                <p>Veuillez remplir les informations concernants les diplomes</p>
                            </div>
                            <hr/>
                            <div style={{
                                margin: "0 20px 0 0",
                                width: "100%",
                                display: "flex",
                                justifyContent: "end",
                            }}>
                                <AiOutlinePlus size="35px"
                                               onClick={() => duplicateChildNodes("tlrh__adding_content-diplomes", "tlrh__adding_content-diplomes-divs")}/>
                            </div>
                            <div className="tlrh__adding_content-diplomes">
                                <div className="tlrh__adding_content-diplomes-divs">
                                    <div>
                                        <label htmlFor="niveau">Niveau</label>
                                        <input type="text" id="niveau" name="niveau" placeholder="Niveau"/>
                                    </div>
                                    <div>
                                        <label htmlFor="ecole">Ecole</label>
                                        <input type="text" id="ecole" name="ecole" placeholder="Ecole"/>
                                    </div>
                                    <div>
                                        <label htmlFor="typeEcole">Type &#201;cole</label>
                                        <select name="typeEcole" id="typeEcole">
                                            <option value="nationale">Nationale</option>
                                            <option value="internationale">Internationale</option>
                                        </select>
                                    </div>
                                    <div>
                                        <label htmlFor="typeDiplome">Type Diplome</label>
                                        <select name="typeDiplome" id="typeDiplome">
                                            <option value="étatique">&Eacute;tatique</option>
                                            <option value="privé">Privé</option>
                                        </select>
                                    </div>
                                    <div>
                                        <label htmlFor="promotion">Promotion</label>
                                        <input type="date" id="promotion" name="promotion" placeholder="dd-mm-yyyy"/>
                                    </div>
                                </div>
                            </div>
                            <div className="tlrh__adding_content-buttons">
                                <button className="tlrh__adding_content-buttonBack" onClick={() => setActive(0)}>Back
                                </button>
                                <button className="tlrh__adding_content-buttonNext" onClick={() => {
                                    setActive(2);
                                    onClick()
                                }}>Next
                                </button>
                            </div>
                        </section>
                    }
                    {
                        isActive === 2 &&
                        <section className="tlrh__adding_content">
                            <div className="tlrh__adding_content-head">
                                <h3>Compétences</h3>
                                <p>Veuillez indiquer le niveau d’expertise de chaque compétence</p>
                            </div>
                            <div style={{
                                margin: "0 20px 0 0",
                                width: "100%",
                                display: "flex",
                                justifyContent: "end",
                            }}>
                                <AiOutlinePlus size="35px"
                                               onClick={() => duplicateChildNodes("tlrh__adding_content-container-comptence")}/>
                            </div>
                            <hr/>
                            <div className="tlrh__adding_content-container tlrh__adding_content-container-comptence">
                                <div>
                                    <input style={{width: "70%",}} type="text" id="competence" name="competence"
                                           className="scale-up-center"
                                           placeholder="competence"/>
                                    <input style={{width: "30%",}} type="text" id="note" name="note"
                                           className="scale-up-center"
                                           placeholder="note"/>
                                </div>
                            </div>
                            <div className="tlrh__adding_content-buttons">
                                <button className="tlrh__adding_content-buttonBack" onClick={() => setActive(1)}>Back
                                </button>
                                <button type="submit" className="tlrh__adding_content-buttonTerminer">Terminer
                                </button>
                            </div>
                        </section>
                    }
                </div>
            </form>
        </div>
    )
}
export default AddCollab

function duplicateChildNodes(className, addClassName) {
    let parent = document.getElementsByClassName(className);
    let child = document.createElement("div")
    child.classList.add(addClassName)
    child.innerHTML = parent[0].firstChild.innerHTML
    parent[0].appendChild(child);
}