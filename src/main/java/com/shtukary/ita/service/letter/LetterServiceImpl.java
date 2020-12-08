package com.shtukary.ita.service.letter;


import com.shtukary.ita.service.mail.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("letterService")
public class LetterServiceImpl implements LetterService {

    private final MailService mailService;

    @Autowired
    public LetterServiceImpl(MailService mailService) {
        this.mailService = mailService;
    }

    @Override
    public void sendLetter(Object object) {
        mailService.sendEmail(object);
    }

}
