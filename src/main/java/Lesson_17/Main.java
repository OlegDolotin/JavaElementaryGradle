package Lesson_17;

import com.google.gson.Gson;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bidimap.TreeBidiMap;
import org.apache.commons.collections4.keyvalue.MultiKey;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        CallLog callLog1 = new CallLog(new Date(3242423), CallType.incoming);
        CallLog callLog2 = new CallLog(new Date(12434534), CallType.outcoming);
        CallLog callLog3 = new CallLog(new Date(5342342), CallType.incoming);
        CallLog callLog4 = new CallLog(new Date(235325), CallType.canceled);
        CallLog callLog5 = new CallLog(new Date(23525232), CallType.incoming);

        Contact contact1 = new Contact("Slava","0987656776");
        Contact contact2 = new Contact("Slava","0765646898");
        Contact contact3 = new Contact("Kristina","0876567675");
        Contact contact4 = new Contact("Lera","0976543674");
        Contact contact5 = new Contact("Piter","0765456789");

        BidiMap<Contact, CallLog> calls = new TreeBidiMap();
        calls.put(contact1, callLog1);
        calls.put(contact2, callLog2);
        calls.put(contact3, callLog3);
        calls.put(contact4, callLog4);
        calls.put(contact5, callLog5);

        System.out.println(calls.toString());
        BidiMap<CallLog, Contact> inverse = calls.inverseBidiMap();
        System.out.println(inverse);

        inverse.removeValue(contact1);
        System.out.println(inverse);

        System.out.println(calls.getKey(callLog3));

        Bag bag = new HashBag();

        bag.add(contact1, 4);
        bag.add(contact2, 7);
        System.out.println(bag);
        System.out.println("contact1 count = "+bag.getCount(contact1));

        bag.remove(contact1, 1);
        System.out.println("contact1 count = "+bag.getCount(contact1));

        MultiKey multiKey1 = new MultiKey(contact1, contact2);
        MultiKey multiKey2 = new MultiKey(contact3, contact3);
        Map<MultiKey, CallLog> logs = new HashMap<>();

        logs.put(multiKey1, callLog1);
        logs.put(multiKey2, callLog3);

        Gson gson = new Gson();
        String gsonString = gson.toJson(logs);
        System.out.println(gsonString);

        Map<MultiKey, CallLog> gsonMap = gson.fromJson(gsonString, Map.class);
        System.out.println(gsonMap);

        CallLog rCall1 = randomLog();
        System.out.println(rCall1);
        CallLog rCall2 = randomLog();
        System.out.println(rCall2);

        System.out.println(getRandomLogs(args));
        System.out.println(getRandomLogs(args));

        Collection<CallLog> collectionBeforeJson = getRandomLogs(args);
        String randomCollectionToJson = gson.toJson(collectionBeforeJson);
        System.out.println(randomCollectionToJson);

        Collection<CallLog> collectionAfterJson = gson.fromJson(randomCollectionToJson, Collection.class);
        System.out.println(collectionAfterJson);
    }


    public static CallLog randomLog(){
        Random random = new Random();
        CallType type;
        switch (random.nextInt(3)){
            case 0:
                type = CallType.canceled;
                break;
            case 1:
                type = CallType.incoming;
                break;
            case 2:
                type = CallType.outcoming;
                break;
                default:
                    type = CallType.canceled;
        }
        return new CallLog(new Date(random.nextLong()), type);
    }

    public static Collection<CallLog> getRandomLogs(String[] args){
        int n;

        if (args.length !=0){
            n = Integer.parseInt(args[0]);
        }else {
            n = 1;
        }

        Collection<CallLog> result = new ArrayList<>();
        for (int i = 0; i < n; i++){
            result.add(randomLog());
        }
        return result;
    }
}
