package leetcode.a300;

import java.util.HashMap;

/**
 * 359. Logger Rate Limiter
 * 日志速率限制器
 * 同于同一种消息，最多允许每10秒钟打印一条信息
 * 原题意不清楚
 */
public class _359Solution {

    class Logger {
        private HashMap<String, Integer> msgDict;

        /** Initialize your data structure here. */
        public Logger() {
            msgDict = new HashMap<String, Integer>();
        }

        /**
         * Returns true if the message should be printed in the given timestamp,
         * otherwise returns false.
         */
        public boolean shouldPrintMessage(int timestamp, String message) {

            if (!this.msgDict.containsKey(message)) {
                this.msgDict.put(message, timestamp);
                return true;
            }

            Integer oldTimestamp = this.msgDict.get(message);
            if (timestamp - oldTimestamp >= 10) {
                this.msgDict.put(message, timestamp);
                return true;
            } else
                return false;
        }
    }
}
