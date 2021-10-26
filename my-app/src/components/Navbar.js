import React, { useState } from 'react';
import {Link } from "react-router-dom";


function Navbar() {
    const [click, setClick] = useState(false);

    const handleClick = () => setClick(!click);

    const closeMobileMenu = () => setClick(false)

    return (
        <React.Fragment>
            <nav className="navbar">
                <div className="navbar-container">
                    <Link to='/'> Travelium <i class="fas fa-plane-departure"></i></Link>
                </div>
                <div className="menu-icon" onClick={handleClick}> 
                    <i className={click ? "fas fa-times" : "fas fa-bars"} />
                </div>
                <ul className={click ? 'nav-menu active' : 'nav-menu'}>
                    <li>    
                        <Link to='/' className='nav-links' onClick={closeMobileMenu}> 
                            Home
                        </Link>
                    </li>
                    <li>    
                        <Link to='/products' className='nav-links' onClick={closeMobileMenu}> 
                            Products
                        </Link>
                    </li>
                    <li>    
                        <Link to='/sign-up' className='nav-links-mobile' onClick={closeMobileMenu}> 
                            Sign Up
                        </Link>
                    </li>
                </ul>
            </nav>
        </React.Fragment>
    )
}

export default Navbar

