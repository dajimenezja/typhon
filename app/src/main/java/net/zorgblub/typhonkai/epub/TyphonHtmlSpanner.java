package net.zorgblub.typhonkai.epub;

import android.text.SpannableStringBuilder;

import net.nightwhistler.htmlspanner.FontResolver;
import net.nightwhistler.htmlspanner.HtmlSpanner;
import net.nightwhistler.htmlspanner.SpanStack;
import net.nightwhistler.htmlspanner.TagNodeHandler;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

/**
 * Created by Benjamin on 5/7/2016.
 */
public class TyphonHtmlSpanner extends HtmlSpanner {

    private boolean skipFurigana = true;

    private boolean addParenthesis = false;

    private int furiganaColor = -1;



    public TyphonHtmlSpanner() {
        super();
        init();
    }

    public TyphonHtmlSpanner(HtmlCleaner cleaner, FontResolver fontResolver) {
        super(cleaner, fontResolver);
        init();
    }

    private void init() {
        registerHandler("rp", new DeleteNodeHandler());
        if(skipFurigana) {
            registerHandler("rt", new DeleteNodeHandler());
        }else{
            registerHandler("rt", new FuriganaHandler());
        }
    }

    private static class DeleteNodeHandler extends TagNodeHandler {
        @Override
        public boolean rendersContent() {
            return true;
        }

        @Override
        public void handleTagNode(TagNode node, SpannableStringBuilder builder, int start, int end, SpanStack spanStack) {
            // Delete
        }
    }

    private class FuriganaHandler extends TagNodeHandler{

        @Override
        public void handleTagNode(TagNode node, SpannableStringBuilder builder, int start, int end, SpanStack spanStack) {
            //TODO
        }
    }

}
