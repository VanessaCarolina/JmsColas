/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colasjms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author Vane
 */
public class TextoListener implements MessageListener {

    /**
    * Casts del mensaje a un mensaje de texto y se muestra por consola
    * @param message mensaje de entrada
    */
    @Override
    public void onMessage(Message message) {
        TextMessage msg = null;
	
        try {
            if (message instanceof TextMessage) {
                msg = (TextMessage) message;
                System.out.println("Recibido asincrono [" + msg.getText() + "]");
            } else {
                System.err.println("El mensaje no es de tipo texto");
            }
        } catch (JMSException e) {
            System.err.println("JMSException en onMessage(): " + e.toString());
        } catch (Throwable t) {
            System.err.println("Exception en onMessage():" + t.getMessage());
        }
    }
}
