package com.example.ai;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

import opennlp.tools.cmdline.parser.ParserTool;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.ParserFactory;
import opennlp.tools.parser.ParserModel;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException;

public class Speak {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws InvalidFormatException, IOException {

		System.out.println("You: ");
		String Command = sc.nextLine();
		System.out.println("\n" + "Jarvis");
		parsing(Command);
		// String[] op = SentenceDetect(Command);
		// for (int i = 0; i < op.length; i++) {
		// String[] tokens = WordsDetect(op[i]);
		// TagPOS(tokens);
		// }
	}

	public static String[] SentenceDetect(String paragraph) throws InvalidFormatException, IOException {

		// Dividing paragraph into different sentences
		InputStream is = new FileInputStream("models/en-sent.bin");
		SentenceModel model = new SentenceModel(is);
		SentenceDetectorME sdetector = new SentenceDetectorME(model);

		String[] sentences = sdetector.sentDetect(paragraph);

		is.close();
		return sentences;
	}

	public static String[] WordsDetect(String Sentence) throws IOException {
		// Dividing sentences into words
		InputStream is = new FileInputStream("models/en-token.bin");
		TokenizerModel model = new TokenizerModel(is);
		TokenizerME wdetector = new TokenizerME(model);
		String[] words = wdetector.tokenize(Sentence);
		return words;
	}

	public static void TagPOS(String[] words) throws IOException {
		// Tagging each word with Parts of Speech tags
		InputStream is = new FileInputStream("models/en-pos-maxent.bin");
		POSModel model = new POSModel(is);
		POSTaggerME tagger = new POSTaggerME(model);
		String[] tags = tagger.tag(words);
		POSSample sample = new POSSample(words, tags);
		System.out.println(sample);
	}

	public static void parsing(String sentence) throws IOException {
		// Parse the sentence as its type along with POS
		InputStream is = new FileInputStream("models/en-parser-chunking.bin");
		ParserModel model = new ParserModel(is);
		opennlp.tools.parser.Parser parser = ParserFactory.create(model);
		Parse parsed[] = ParserTool.parseLine(sentence, parser, 1);
		for (Parse p : parsed) {
			// Show the results on console
			p.show();
		}
	}
}
