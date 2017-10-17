#####
```java
private ArrayList<Row> parse(String string) {
        Gson gson = new Gson();
        SubwayTransitInfo info = gson.fromJson(string, SubwayTransitInfo.class); //항상 최상위 클래스를 가져와야 한다.
        List<Row> list = info.getStationDayTrnsitNmpr().getRow();

        return (ArrayList) list;
}
```
##### Gson으로 데이터를 가져 올 때 항상 최 상위 클래스를 가져와야 한다.
##### 최상위 클래스란 JSon 자체를 말함. 그 아래 StationDayTrnsitNmpr이 있고 그 아래 Sub 클래스가 있는 구조이다.
```
{"StationDayTrnsitNmpr":{"list_total_count":44,"RESULT":{"CODE":"INFO-000","MESSAGE":"정상 처리되었습니다"},"row":[{"SN":"1","STATN_NM":"신도림","WKDAY":333873.0,"SATDAY":298987.0,"SUNDAY":216886.0},{"SN":"44","STATN_NM":"이촌","WKDAY":12802.0,"SATDAY":46939.0,"SUNDAY":10681.0}]}}
```

##### JSON 데이터를 클래스로 만드는 방법
##### 원래는 받아온 데이터를 String 함수를 이용하여 잘라야 하지만 Gson 클래스를 이용하면 손쉽게 데이터를 얻을 수 있다.
##### 그리고 Pojo 사이트를 이용하면 JSON 데이터를 클래스로 만들 수 있다.
