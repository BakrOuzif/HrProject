import React from 'react';
import {GrUserWorker, GrUserManager} from 'react-icons/gr'
import {AiOutlineHome} from 'react-icons/ai'
import {FiLogOut} from 'react-icons/fi'
import {HiOutlineDocumentReport} from 'react-icons/hi'


import {Profile} from '../../../assets'
import './sidebar.css';

const Sidebar = () =>{
    const Primary_text_color = "#FFE5B4"
    return (
        <div className="tlrh__sidebar">
            <div className="tlrh__sidebar-title">
                <div className="line"></div>
                <h1>TLRH Manager</h1>
            </div>
            <div className="tlrh__sidebar-profile">
                <img src={Profile} alt="profile.png"/>
                <h3>Karthi Madesh</h3>
                <h4>Admin</h4>
            </div>
            <div className="tlrh__sidebar-links">
                <div id="tlrh__sidebar-links_active">
                    <AiOutlineHome size={20} />
                    <p>Home</p>
                </div>
                <div>
                    <GrUserWorker size={20} />
                    <p>Collaborateurs</p>
                </div>
                <div>
                    <GrUserManager size={20} />
                    <p>Manageurs RH</p>
                </div>
                <div>
                    <HiOutlineDocumentReport size={20} />
                    <p>Report</p>
                </div>
                <div className="tlrh__sidebar-links_bottom">
                    <FiLogOut size={20} />
                    <p>Log Out</p>
                </div>
            </div>
        </div>

    )
}
export default Sidebar