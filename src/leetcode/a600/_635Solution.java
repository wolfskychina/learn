package leetcode.a600;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
/**
 * 日志存储器
 */
public class _635Solution {

    class LogSystem {

        private List<Log> list;

        public class Log {
            int id;
            String timestamp;
        }

        public LogSystem() {
            this.list = new LinkedList<>();
        }

        public void put(int id, String timestamp) {

            Log log = new Log();
            log.id = id;
            log.timestamp = timestamp;
            list.add(log);

        }

        /**
         * Year:Month:Day:Hour:Minute:Second, for example, 2017:01:01:23:59:59
         * 
         * @return
         */
        public List<Integer> retrieve(String start, String end, String granularity) {

            int idx = 0;
            switch (granularity) {
                case "Year":
                    idx = 4;
                    break;
                case "Month":
                    idx = 7;
                    break;
                case "Day":
                    idx = 10;
                    break;
                case "Hour":
                    idx = 13;
                    break;
                case "Minute":
                    idx = 16;
                    break;
                default:
                    idx = 19;
            }

            start = start.substring(0, idx);
            end = end.substring(0, idx);
            Set<Integer> res = new HashSet<>();
            for (Log log : list) {
                String str = log.timestamp.substring(0, idx);
                if (str.compareTo(start) >= 0 && str.compareTo(end) <= 0) {
                    res.add(log.id);
                }
            }

            return new LinkedList<Integer>(res);

        }
    }

    public static void main(String[] args){
        _635Solution so = new _635Solution();
        LogSystem sys = so.new LogSystem(); 
        sys.put(1,"2017:01:01:23:59:59");
        sys.put(2,"2017:01:01:22:59:59");
        sys.put(3,"2016:01:01:00:00:00");
        sys.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year");
        sys.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour");


    }
}
