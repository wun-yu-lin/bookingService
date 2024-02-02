#  booking service 

## project environment
- Language: Java 17
- Type: Gradle
- Spring Boot: 3.1.2
- SQL: Spring Data JPA
- Database: PostgreSQL 16


## 測試 URL & endpoint 
請使用 postman 或是其他 API 測試工具, 以下提供測試用的 URL & endpoint
 - [GET] http://123.241.21.121:8081/booking : Get booking by id & mode
   - para1: id, integer
   - para2: mode, string (air/ocean)
   - example: http://123.241.21.121:8081/booking?id=2&mode=air
   

- [POST] http://123.241.21.121:8081/booking : Post booking
  - body:
  ```json
  {
   "mode": "air",
   "cargo": "iPhone",
   "quantity": 1000,
   "from": "Tianjin Xingang Pt, Tianjin, CN",
   "to": "New York, New York, US"
  }
  ```


- [DELETE] http://123.241.21.121:8081/booking Delete booking by id and mode
  - para1: id, integer
  - para2: mode, string (air/ocean)
  - example: http://123.241.21.121:8081/booking?id=1&mode=air


## 專案資料夾結構
```tree
    
├── README.md
├── build.gradle
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── gradlew
├── gradlew.bat
├── settings.gradle
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── example
    │   │           └── bookingservice
    │   │               ├── BookingServiceApplication.java
    │   │               ├── constant
    │   │               │   └── BookingMode.java
    │   │               ├── controller
    │   │               │   └── BookingController.java
    │   │               ├── dao
    │   │               │   ├── AirBookingRepository.java
    │   │               │   └── OceanBookingRepository.java
    │   │               ├── dto
    │   │               │   └── BookingDto.java
    │   │               ├── exception
    │   │               │   ├── DataNoFoundException.java
    │   │               │   └── ExceptionHanding.java
    │   │               ├── model
    │   │               │   ├── AirBookingModel.java
    │   │               │   ├── OceanBookingModel.java
    │   │               │   └── superClass
    │   │               │       └── BookingModel.java
    │   │               ├── service
    │   │               │   ├── BookingService.java
    │   │               │   └── BookingServiceImpl.java
    │   │               └── vo
    │   │                   └── BookingVO.java
    │   └── resources
    │       ├── application.properties
    │       ├── static
    │       └── templates


```


## Question:
- if a new mode “road” will be added shortly, please think about the future requirements. How will you design API to meet your needs?
1. 使用 enum 限制 mode 的種類，後續新增 mode 只需要在 enum 中新增即可，方便管理資料類型。
2. 資料庫不同模式的資料表/Repository/Model 分開存放，並且使用相同的 API 進行操作，透過 enum 管理資料類別，在 Service 層做邏輯判斷並 access 對應 repository，以便後續修改的彈性。
3. AirBooking & OceanBooking model 資料表繼承 superClass BookingModel 共用相同的欄位，並且各自新增自己的欄位，後續 RoadBooking 可以繼承 BookingModel 並且新增自己的欄位。
