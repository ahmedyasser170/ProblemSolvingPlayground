package MediumProblems;

import javafx.util.Pair;

import java.util.*;

public class RewardTopKStudents {

  public static void main(String[] args) {
//    String[] positive_feedback = {"smart", "brilliant", "studious"}, negative_feedback = {"not"}, report = {"this student is studious", "the student is smart"};
//    int[] student_id = {1, 2};
//    int k = 2;
    String[] positive_feedback = {"fkeofjpc","qq","iio"}, negative_feedback = {"jdh","khj","eget","rjstbhe","yzyoatfyx","wlinrrgcm"}, report = {"rjstbhe eget kctxcoub urrmkhlmi yniqafy fkeofjpc iio yzyoatfyx khj iio","gpnhgabl qq qq fkeofjpc dflidshdb qq iio khj qq yzyoatfyx","tizpzhlbyb eget z rjstbhe iio jdh jdh iptxh qq rjstbhe","jtlghe wlinrrgcm jnkdbd k iio et rjstbhe iio qq jdh","yp fkeofjpc lkhypcebox rjstbhe ewwykishv egzhne jdh y qq qq","fu ql iio fkeofjpc jdh luspuy yzyoatfyx li qq v","wlinrrgcm iio qq omnc sgkt tzgev iio iio qq qq","d vhg qlj khj wlinrrgcm qq f jp zsmhkjokmb rjstbhe"};
    int[] student_id = {96537918,589204657,765963609,613766496,43871615,189209587,239084671,908938263};
    int k = 3;
    System.out.println(topStudents(positive_feedback, negative_feedback, report, student_id, k));
  }

  public static List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
    HashSet<String> positiveSet, negativeSet;
    positiveSet = new HashSet<>(Arrays.asList(positive_feedback));
    negativeSet = new HashSet<>(Arrays.asList(negative_feedback));

    HashMap<Integer, Integer> studentFeedbackPoints = new HashMap<>();
    for (int i = 0; i < report.length; i++) {
      int currentStudentId = student_id[i];
      if (!studentFeedbackPoints.containsKey(currentStudentId))
        studentFeedbackPoints.put(currentStudentId, 0);

      String[] reportWords = report[i].split(" ");
      for (String word : reportWords) {
        if (positiveSet.contains(word))
          studentFeedbackPoints.put(currentStudentId, studentFeedbackPoints.getOrDefault(currentStudentId, 0) + 3);
        if (negativeSet.contains(word))
          studentFeedbackPoints.put(currentStudentId, studentFeedbackPoints.getOrDefault(currentStudentId, 0) - 1);
      }
    }

    PriorityQueue<Map.Entry<Integer, Integer>> mapRecordEntryPriorityQueue = new PriorityQueue<>(((o1, o2) ->{
      return (o2.getValue() < o1.getValue()) ? -1 : ((o2.getValue() == o1.getValue()) ? Integer.compare(o1.getKey(), o2.getKey()) : 1);
    }));
    mapRecordEntryPriorityQueue.addAll(studentFeedbackPoints.entrySet());

    ArrayList<Integer> sortedStudents = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      sortedStudents.add(mapRecordEntryPriorityQueue.remove().getKey());
    }
    return sortedStudents;
  }
}
