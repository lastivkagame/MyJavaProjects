import React, {useState, useEffect} from 'react';
import './App.css';
import { Button } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
//import { setEnvironmentData } from 'worker_threads';
import {Link} from 'react-router-dom'

function Shop() {
    useEffect(()=>{
        fetchItems();
       
    }, []);

    const [items, setItems] = useState([]);

    
    
    const fetchItems =  async () => {
        const data = await 
        fetch('https://fakestoreapi.com/products/categories/'); ///categories .. products/ 
        //.then(res=>res.json())
        
           // .then(json=>console.log(json)); ////fetch('https://fakestoreapi.com/products/');

        const items = await data.json();
        console.log(items);
        setItems(items);
    }
        //.then(data=>this.setState({clients: data}))
        //const items = await data.json();
        //console.log(items);
        //setItems(items);
    
  return (
   <div className="App">
       {items.map(item=>(
        //    <h1 key={item}>{item}</h1>
        
           <Link key={item} to={`/Shop/${item}`}><h1>{item}</h1></Link>
        //    <h1 key={item.id}>{item.category}</h1>
       ))}
   </div>
  );
}

export default Shop;
