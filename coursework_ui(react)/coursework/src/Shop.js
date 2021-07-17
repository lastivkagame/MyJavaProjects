import React, {useState, useEffect} from 'react';
import './App.css';
import { Button } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

function Shop() {
    useEffect(()=>{
        fetchItems();
    }, []);

    const [items, setItems] = useState([]);

    const fetchItems =  async () => {
        const data = await 
        fetch('https://fakestoreapi.com/products/1')
            .then(res=>res.json())
            .then(json=>console.log(json)); ////fetch('https://fakestoreapi.com/products/');
        console.log(data);

        const items = await data.json();
        console.log(items);
        //setItems(items);
    }
  return (
   <div className="App">
       {/* {items.map(item=>(
           <h1>{item.name}</h1>
       ))} */}
   </div>
  );
}

export default Shop;
