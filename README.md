# 좌표 계산기

## 선 길이

### 기능 요구사항

- 사용자가 점에 대한 좌표 정보를 입력하는 메뉴를 구성한다. 
- 좌표 정보는 괄호"(", ")"로 둘러쌓여 있으며 쉼표(,)로 x값과 y값을 구분한다. 
- X, Y좌표 모두 최대 24까지만 입력할 수 있다. 
- 입력 범위를 초과할 경우 에러 문구를 출력하고 다시 입력을 받는다. 
- 정상적인 좌표값을 입력한 경우, 해당 좌표에 특수문자를 표시한다. 
- 좌표값을 두 개 입력한 경우, 두 점을 있는 직선으로 가정한다. 좌표값과 좌표값 사이는 '-' 문자로 구분한다. 
- 직선인 경우는 두 점 사이 거리를 계산해서 출력한다.

### 이벤트

1. 사용자가 식을 입력했다.
2. 식이 계산됐다.


### 모델링

- 선 길이 계산기
  - 행위
    - 식을 입력 받아  좌표 그래프에 그리고 직선상의 거리를 계산한다.
- 좌표
  - 상태
    - x값과 y값을 가진다.
      - 좌표는 0이상 24이하의 자연수이다.
  - 행위
    - 좌표를 입력받으면 직선상의 거리를 계산한다.
- 좌표 그래프
  - 행위
    - 좌표 두 개를 입력 받아 표를 그린다.
      - 표를 그린다.
      - 표에 점을 찍는다.
      - 표를 출력한다.
