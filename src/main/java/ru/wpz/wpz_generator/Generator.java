package ru.wpz.wpz_generator;

import ru.wpz.wpz_generator.domain.Message;
import ru.wpz.wpz_generator.kafka.KafkaTopic;
import ru.wpz.wpz_generator.kafka.core.KafkaHelper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Generator {

    private final KafkaHelper kafkaHelper;

    public Generator(KafkaHelper kafkaHelper) {
        this.kafkaHelper = kafkaHelper;
    }

    Map<Integer, Integer> mapGenerator = new HashMap<>()
    {{ put(333, 0); put(334, 0); put(335, 0); put(336, 0); put(337, 0); put(338, 0); put(339, 0); put(340, 0); put(341, 0); put(342, 0); put(343, 0);
        put(344, 0); put(345, 0); put(346, 0); put(347, 0); put(348, 0); put(349, 0); put(350, 0); put(351, 0); put(352, 0); put(353, 0); put(354, 0);
        put(355, 0); put(356, 0); put(357, 0); put(358, 0); put(359, 0); put(360, 0); put(361, 0); put(362, 0); put(363, 0); put(364, 0); put(365, 0);
        put(366, 0); put(367, 0); put(368, 0); put(369, 0); put(370, 0); put(371, 0); put(372, 0); put(373, 0); put(374, 0); put(375, 0); put(376, 0);
        put(377, 0); put(378, 0); put(379, 0); put(380, 0); put(381, 0); put(382, 0); put(383, 0); put(384, 0); put(385, 0); put(386, 0); put(387, 0);}};

    public void methodGenerator(){
        Thread t1 = new Thread(() -> {
            while (true) {
                try {
                    creatMessage();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t1.setDaemon(true);
        t1.start();
    }

    private void creatMessage() throws Exception {
        int i = 0;
        Message message = new Message();

        while (true) {
            Thread.sleep(10000);
            i = ThreadLocalRandom.current().nextInt(333, 387);
            if(mapGenerator.get(i) == 0){
                mapGenerator.put(i, 1);
            } else {
                mapGenerator.put(i, 0);
            }
            sendMassage(i, message);
        }
    }

    private void sendMassage(int devId, Message message){
        message.setDevId(devId);
        message.setStatus(mapGenerator.get(devId));
        kafkaHelper.sendTo(KafkaTopic.TEST, message.toString());
    }
}
