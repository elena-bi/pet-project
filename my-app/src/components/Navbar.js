import React from 'react'
import { BrowserRouter, Route, Link } from "react-router-dom";


function Navbar() {
    return (
        <>
            <nav className="navbar">
                <div className="navbar-container">
                    <Link to='/'> Travelium <i class="fas fa-plane-departure"></i></Link>
                </div>
                <div className="menu-icon"> <i class="fas fa-bars"></i></div>
            </nav>
        </>
    )
}

export default Navbar

