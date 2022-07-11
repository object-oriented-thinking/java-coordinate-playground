### 요구사항
고객이 예약할 때 여행할 목적지의 대략적인 이동거리를 입력 받음

이동거리를 활용해 차량 별로 필요한 연료를 주입

차량 별로 주입해야 할 연료량을 확인할 수 있는 보고서를 생성해야 한다.

### 차량별 연비
* Sonata : 10km/리터
* Avante : 15km/리터
* K5 : 13km/리터


### 구현 목록

- [x] Car 추상 클래스
- [x] Sonata, K5, Avante 클래스
  - [x] getDistancePerLiter: 연비(리터 당 이동거리) 반환
  - [x] getTripDistance: 여행 거리 반환
  - [x] getName: 차 이름 반환
  - [x] getChargeQuantity: 주입해야 할 연료 양 반환
  
- [x] RentCompany 클래스
  - [x] addCar: 내부 carList에 객체 추가 
  - [x] generateReport: 출력을 위한 report String 형식으로 반환
