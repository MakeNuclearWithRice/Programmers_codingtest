package hash;

import java.util.*;

public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> count = new HashMap<>();
        Map<String, PriorityQueue<int[]>> songList = new HashMap<>(); // 장르별 노래를 저장할 우선순위 큐

        for (int i = 0; i < genres.length; i++) {
            count.put(genres[i], count.getOrDefault(genres[i], 0) + plays[i]);

            songList.putIfAbsent(genres[i], new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1])));
            songList.get(genres[i]).offer(new int[]{i, plays[i]});
        }

        List<String> genreOrder = new ArrayList<>(count.keySet());
        genreOrder.sort(Collections.reverseOrder());
        List<Integer> answerList = new ArrayList<>();
        for (String genre : genreOrder) {
            PriorityQueue<int[]> pq = songList.get(genre);
            int countForGenre = 0;
            while (!pq.isEmpty() && countForGenre < 2) {
                answerList.add(pq.poll()[0]);
                countForGenre++;
            }
        }

        return answerList.stream().mapToInt(i -> i).toArray();
    }
}
