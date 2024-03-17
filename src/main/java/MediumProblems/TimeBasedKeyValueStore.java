package MediumProblems;

import javafx.util.Pair;

import java.util.*;

public class TimeBasedKeyValueStore {
  //["TimeMap","set","set","get","get","get","get","get"]
  //  [[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["love",20],["love",25]]
  public static void main(String[] args) {
    TimeMap timeMap = new TimeMap();
    timeMap.set("love", "high", 10);  // store the key "foo" and value "bar" along with timestamp = 1.
    timeMap.set("love", "low", 20);  // store the key "foo" and value "bar" along with timestamp = 1.
    System.out.println(timeMap.get("love", 5));         // return "bar"
    System.out.println(timeMap.get("love", 10));         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
    System.out.println(timeMap.get("love", 15));         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
    System.out.println(timeMap.get("love", 20));         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
    System.out.println(timeMap.get("love", 25));         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
    //    timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
    //    System.out.println(timeMap.get("foo", 4));         // return "bar2"
    //    System.out.println(timeMap.get("foo", 5));         // return "bar2"

  }

}


class TimeMap {

  HashMap<String, List<Pair<Integer, String>>> hashMap;

  public TimeMap() {
    hashMap = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    if (!hashMap.containsKey(key))
      hashMap.put(key, new ArrayList<>());

    List<Pair<Integer, String>> tempPairList = hashMap.get(key);
    tempPairList.add(new Pair<>(timestamp, value));
  }

  public String get(String key, int timestamp) {
    List<Pair<Integer, String>> tempPairList = hashMap.get(key);
    int result = 0, left = 0, right = tempPairList.size() - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      Pair<Integer, String> currentPair = tempPairList.get(mid);
      if (currentPair.getKey() == timestamp) {
        return currentPair.getValue();
      } else if (currentPair.getKey() < timestamp) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    result = left - 1;
    if (result < 0)
      return "";
    //    result =
    return tempPairList.get(result).getValue();
  }

}
