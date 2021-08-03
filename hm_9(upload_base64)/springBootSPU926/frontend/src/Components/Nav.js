import React from 'react';
import './../App.css';
import { Button } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import {Link} from 'react-router-dom'

function Nav() {
    const navStyle = {
        color: 'white'
    };

  return (
   <nav>
       <h3>Logo</h3>
       <ul className="nav-links">
           <Link style={navStyle} to='/'>
               <li>Home</li>
            </Link>
           <Link style={navStyle} to='/AddAnimal'>
               <li>Add Animal</li>
           </Link>
           <Link style={navStyle} to='/EditAnimal'>
               <li>Edit Animal</li>
           </Link>
           <Link style={navStyle} to='/DeleteAnimal'>
               <li>Delete Animal</li>
           </Link>
       </ul>
   </nav>
  );
}

export default Nav;