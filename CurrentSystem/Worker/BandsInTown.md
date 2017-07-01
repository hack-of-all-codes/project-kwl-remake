# Worker Subsystem: Bands in Town
Using the MBID of the artists, we can fetch the latest events

###### Data Source Summary
| Attribute       | Data  |
| ----------------| ------|
| Type            | REST  |
| Sample Request  | https://api.bandsintown.com/artist/mbid_73e5e69d-3554-40d8-8516-00cb38737a1c/events.json?app_id=xxxxx_id_xxxx&artist_id=10092511675&date=4234234 |
| Response Type | JSON |

###### Response Body
| Attribute       | Type    | Description   |
| --------------- | ------- | ------------- |
| id              | String  |               |
| datetime        | String  |               |
| title           | String  |               |
| venue           | Venue   |               |

###### Venue
| Attribute       | Type    | Description   |
| --------------- | ------- | ------------- |
| id | |
| city | |
| name | |
| latitude | |
| longitude | |
| region | |
| country | |

Response:


###### Resources:
[Bands in Town: API](https://www.programmableweb.com/api/bandsintown)
