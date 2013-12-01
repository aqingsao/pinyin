package com.pinyin.domain;

import java.util.Date;

public class Email {

    private long id;

    protected String subject;

    private String message;

    private Address from;

    private Address to;

    private String status = "SENDING";

    private String[] attachments = new String[0];

    private Date createdAt;

    private Date updatedAt;

    public Email(Address from, String subject, String message, Address to, String... attachments) {
        this.from = from;
        this.subject = subject;
        this.message = message;
        this.to = to;

        this.attachments = attachments;
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    public Email() {
    }

    public static Email anEmail(Address from, String subject, String message, Address to, String... attachments) {
        return new Email(from, subject, message, to, attachments);
    }


//    public MimeMessage buildMessage(Session session) throws MessagingException {
//        MimeMessage message = initMessage(session);
//
//        MimeMultipart multiPart = new MimeMultipart();
//        multiPart.addBodyPart(asContentPart(this.getMessage()));
//
//        for (String attachment : attachments) {
//            LOGGER.info("Add attachment " + attachment);
//            multiPart.addBodyPart(asAttachmentPart(attachment));
//        }
//        message.setContent(multiPart);
//
//        return message;
//    }
//
//    private MimeBodyPart asAttachmentPart(String attachment) throws MessagingException {
//        MimeBodyPart attachmentPart = new MimeBodyPart();
//
//        FileDataSource dataSource = new FileDataSource(attachment);
//        attachmentPart.setDataHandler(new DataHandler(dataSource));
//        attachmentPart.setFileName(dataSource.getName());
//        return attachmentPart;
//    }
//
//    private MimeBodyPart asContentPart(String emailContent) throws MessagingException {
//        MimeBodyPart bodyPart = new MimeBodyPart();
//        bodyPart.setContent(emailContent, TYPE_HTML_UTF_8);
//        return bodyPart;
//    }
//
//    private MimeMessage initMessage(Session session) throws MessagingException {
//        MimeMessage message = new MimeMessage(session);
//
//        message.setFrom(from.getFrom().toInternetAddress());
//        message.setSubject(subject);
//        message.setSentDate(new java.util.Date());
//
//        if (from.getReplyTo() != null) {
//            message.setReplyTo(new javax.mail.Address[]{from.getReplyTo().toInternetAddress()});
//        }
//        message.setRecipients(Message.RecipientType.TO, toInternetAddresses(this.recipients.getToAddresses()));
//        message.setRecipients(Message.RecipientType.CC, toInternetAddresses(this.recipients.getCCAddresses()));
//        message.setRecipients(Message.RecipientType.BCC, toInternetAddresses(recipients.getBCCAddresses()));
//
//        return message;
//    }

    public String getMessage() {
        return message;
    }

    public String getSubject() {
        return subject;
    }

    public Address getFrom() {
        return from;
    }

    public String getStatus() {
        return status;
    }

    public Email setStatus(String status) {
        this.status = status;
        return this;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setFrom(Address from) {
    }

    public void setTo(Address to) {
        this.to = to;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Address getTo() {
        return to;
    }
}
