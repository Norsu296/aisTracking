import React, { useState, useEffect } from 'react'
import Map from './Map'
import L from 'leaflet';
import 'leaflet-geometryutil';

const Main = () => {

    const API_URL = "http://localhost:8080"

    const [range, setRange] = useState(0);
    const [ships, setShips] = useState([]);
    const [bases, setBases] = useState([]);
    const [rockets, setRockets] = useState([]);

    const handleRange = (e) => {
        setRange(e.target.value)
    }
    const handleReset = () => {
        window.location.reload(false);
    }
    useEffect(() => {
        loadShips();
        loadBases();
        loadRockets();
    }, [])

    const loadShips = () => {
        fetch(API_URL+"/ships")
        .then(results => results.json())
        .then(data => {
            console.log(data);
            setShips(data)
        })
    }
    const loadBases = () => {
        fetch(API_URL+"/bases")
        .then(results => results.json())
        .then(data => {
            console.log(data);
            setBases(data)
        })
    }
    const loadRockets = () => {
        fetch(API_URL+"/rockets")
        .then(results => results.json())
        .then(data => {
            console.log(data);
            setRockets(data)
        })
    }

    return(
        <div className="row ">
            <div className="col-md-9 map">
                <Map shipPositions={ships} range={range} basePositions={bases}></Map>
            </div>
            <div className="col-md-3">
                        <form className="row g-3">
                            <div className="col-md-9">
                                <select className="form-select" onChange={handleRange}>
                                <option selected disabled value="">Wybierz rodzaj uzbrojenia</option>
                                        {rockets.map(item => 
                                             <option key={item.id} value={item.range}>{item.name}</option>)};
                                </select>
                                <div class="alert alert-secondary" role="alert">
                                    Kliknij na statek aby zobaczyć możliwy zasięg
                                    <p>
                                        Kliknij ponownie aby sprawdzić zagrożenia
                                    </p>
                                </div>
                                <button type="button" class="btn col-md-3 btn-outline-dark" onClick={handleReset}>Reset</button>
                            </div>
                            
                        </form>
            </div>
        </div>
    )
}

export default Main;