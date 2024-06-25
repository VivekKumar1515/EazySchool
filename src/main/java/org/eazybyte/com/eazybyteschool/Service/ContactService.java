package org.eazybyte.com.eazybyteschool.Service;

import org.eazybyte.com.eazybyteschool.Model.Contact;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class ContactService {

    Logger logger = Logger.getLogger(this.getClass().getName());

    public boolean saveMessageDetails(Contact contact) {
        boolean isSaved = true;
        logger.info(contact.toString());
        return isSaved;
    }
}
