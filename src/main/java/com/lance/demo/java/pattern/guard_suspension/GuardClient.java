package com.lance.demo.java.pattern.guard_suspension;

import java.util.concurrent.TimeUnit;

public class GuardClient {
    public void demo() throws Exception{
        SendAlarmAction sendAlarmAction = new SendAlarmAction();
        for (int i = 0; i < 100; i++) {
            final String title = i + "";
            new Thread(() -> sendAlarmAction.sendAlarm(new AlarmInfo(title,"biu biu biu...."))).start();
        }

        TimeUnit.SECONDS.sleep(5);
        sendAlarmAction.changeState();
    }

    private class SendAlarmAction{
        private volatile boolean isStateOK = false;
        private final Predicate stateBeOK = () -> isStateOK;
        private Broker broker = new ConditionBroker();

        void sendAlarm(AlarmInfo alarmInfo) {
            GuardAction<AlarmInfo> guardAction = new GuardAction<AlarmInfo>(stateBeOK) {
                @Override
                public AlarmInfo call(){
                    System.out.println(".....alarm "+alarmInfo.toString());
                    return alarmInfo;
                }
            };

            try {
                broker.callWithGuard(guardAction);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        void changeState() {
            try {
                broker.broadcastAfter(() -> {
                    isStateOK=true;
                    return true;
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
