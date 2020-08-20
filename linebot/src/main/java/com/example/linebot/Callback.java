package com.example.linebot;

import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.FollowEvent;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.ImageMessage;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.net.URI;
import java.time.LocalTime;
import java.util.List;
import java.util.Random;

    @LineMessageHandler
    public class Callback {

        private static final Logger log = LoggerFactory.getLogger(Callback.class);

        // フォローイベントに対応する
        @EventMapping
        /*public TextMessage handleFollow(FollowEvent event) {
            // 実際の開発ではユーザIDを返信せず、フォロワーのユーザIDをデータベースに格納しておくなど
            String userId = event.getSource().getUserId();
            return reply("あなたのユーザIDは " + userId);
        }*/

        // 返答メッセージを作る
        private TextMessage reply(int text)throws Exception {
            Question question = new Question();
            List<PreExam> returning = question.selectPreExams(text);
            return new TextMessage(returning.get(0).getMonndai()+returning.get(0).getSentaku1()+returning.get(0).getSentaku2()
            +returning.get(0).getSentaku3()+returning.get(0).getSentaku4());

        }
/*
        // 文章で話しかけられたとき（テキストメッセージのイベント）に対応する
        @EventMapping
        public Message handleMessage(MessageEvent<TextMessageContent> event) {
            TextMessageContent tmc = event.getMessage();
            String text = tmc.getText();
            switch (text) {
                case "やあ":
                    return greet();
                /*case "おみくじ":
                    return replyOmikuji();
                
                default:
                    return reply(text);
            }
        }*/
/*
        // あいさつする
        private TextMessage greet() {
            LocalTime lt = LocalTime.now();
            int hour = lt.getHour();
            if (hour >= 17) {
                return reply("こんばんは！");
            }
            if (hour >= 11) {
                return reply("こんにちは！");
            }
            return reply("おはよう！");
        }


        // 画像メッセージを作る
        private ImageMessage replyImage(URI url) {
            // 本来は、第一引数が実際の画像URL、第二画像がサムネイルのurl

            return new ImageMessage(url,url);
        }

        // ランダムにおみくじ画像を返す
        private ImageMessage replyOmikuji() {
            var ranNum = new Random().nextInt(3);
            var uriString = "";
            switch (ranNum) {
                case 2:
                    uriString = "https://3.bp.blogspot.com/-vQSPQf-ytsc/T3K7QM3qaQI/AAAAAAAAE-s/6SB2q7ltxwg/s1600/omikuji_daikichi.png";
                    break;
                case 1:
                    uriString = "https://2.bp.blogspot.com/-27IG0CNV-ZE/VKYfn_1-ycI/AAAAAAAAqXw/fr6Y72lOP9s/s400/omikuji_kichi.png";
                    break;
                case 0:
                default:
                    uriString = "https://4.bp.blogspot.com/-qCfF4H7YOvE/T3K7R5ZjQVI/AAAAAAAAE-4/Hd1u2tzMG3Q/s1600/omikuji_kyou.png";
            }
            return replyImage(URI.create(uriString));
        }*/
    }


