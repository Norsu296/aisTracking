import React, {useState} from 'react'
import L from 'leaflet';
import 'leaflet-geometryutil';
import 'leaflet/dist/leaflet.css';
import { MapContainer, TileLayer, Marker, Popup, Circle } from 'react-leaflet'
import vesselIcon from '../images/shipColor.png'
import eagleIcon from '../images/base.png'


const shipIcon = new L.icon({
  iconUrl: vesselIcon,
  iconSize: [30, 30]
})
const baseIcon = new L.icon({
  iconUrl: eagleIcon,
  iconSize: [40, 40]
})

const Map = (props) => {

  const [distance, setDistance] = useState([]);
  const [basesAtRisk, setBasesAtRisk] = useState(0);

  const getDistance = (lat1, lon1, lat2, lon2) => {
    let R = 6371; 
    let dLat = toRad(lat2-lat1);
    let dLon = toRad(lon2-lon1); 
    let a = Math.sin(dLat/2) * Math.sin(dLat/2) +
            Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) * 
            Math.sin(dLon/2) * Math.sin(dLon/2); 
    let c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
    let d = R * c;
    return d;
  }

  const toRad = (degree) => {
    return degree*Math.PI/180;
  }

  const findBasesAtRisk = () => {
    let bases = 0;
    for(let i = 0; i < distance.length; i++){
      if(props.range/1000 >= distance[i]){
        bases = bases + 1;
      }
    }
    setBasesAtRisk(bases);
  }


  const Ships = props.shipPositions.map(ship => (
    <Marker position={[ship.positionX, ship.positionY]} icon={shipIcon} eventHandlers={{
      click: (e) => {
        let distances = []
        for(let i = 0; i< props.basePositions.length ; i++){
          distances.push(getDistance(e.latlng.lat, e.latlng.lng, props.basePositions[i].positionX, props.basePositions[i].positionY));
          setDistance(distances);
        }
        findBasesAtRisk();       
      }
    }}>
      <Popup>
        <div>
          {ship.name}
        </div>
        <Circle center={[ship.positionX, ship.positionY]} radius={props.range} pathOptions={{color: 'red'}}></Circle>  
      </Popup>
    </Marker>
  )) 

  const Bases = props.basePositions.map(base => (
    <Marker position={[base.positionX, base.positionY]} icon={baseIcon}>
    <Popup>
      <div>
         {base.name}
      </div>
    </Popup>
  </Marker>
  ))

  return (
    <>
      <MapContainer center={[63.460798, 10.254517]} zoom={10} scrollWheelZoom={false}>
        <TileLayer
          attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
          url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
        />
          {Ships}
          {Bases}
          
      </MapContainer>
      <h1 className={`${basesAtRisk > 0 ? '' : 'd-none '}alert alert-danger d-flex justify-content-center shadow`}>
        Potencjalnie zagrożone cele: {basesAtRisk}
      </h1>
    </>
  );
}

export default Map;