package task44.service;

import task44.dao.ReceiverDAO;
import task44.dao.impl.ReceiverDAOImpl;
import task44.dto.Receiver;

import java.util.ArrayList;

public class ReceiverService {
    private ReceiverDAO receiverDAO = new ReceiverDAOImpl();

    public Receiver getReceiver(int number) {
        return receiverDAO.getReceiver(number);
    }

    public ArrayList<Receiver> getReceivers() {
        return receiverDAO.getReceivers();
    }

    public int addReceiver(Receiver receiver) {
        return receiverDAO.addReceiver(receiver);
    }
}
