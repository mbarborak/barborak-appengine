package com.barborak;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.alicebot.ab.AIMLProcessor;
import org.alicebot.ab.Bot;
import org.alicebot.ab.Chat;
import org.alicebot.ab.Graphmaster;
import org.alicebot.ab.MagicStrings;
import org.alicebot.ab.PCAIMLProcessorExtension;

@WebServlet(name = "ChatBot", urlPatterns = { "/chatbot" })
public class ChatBotAppEngine extends HttpServlet {

	static final Chat chatSession;

	static {
		MagicStrings.root_path = "./resources";
		AIMLProcessor.extension = new PCAIMLProcessorExtension();
		String botName = "sassubot";
		Graphmaster.enableShortCuts = true;
		Bot bot = new Bot(botName, MagicStrings.root_path, "chat");
		chatSession = new Chat(bot);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");

		synchronized (chatSession) {
			String msg = req.getReader().lines().collect(Collectors.joining());
			resp.getWriter().print(chatSession.multisentenceRespond(msg));
		}
	}
}