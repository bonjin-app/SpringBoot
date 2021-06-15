package kr.co.bonjin.slackhook.model;

import com.slack.api.model.block.Blocks;
import com.slack.api.model.block.LayoutBlock;
import com.slack.api.model.block.composition.BlockCompositions;
import com.slack.api.model.block.element.BlockElements;

public class SlackMessageBlock {

    public static LayoutBlock getHeader(String text) {
        return Blocks.header(h -> h.text(
                BlockCompositions.plainText(pt ->
                        pt.emoji(true)
                                .text(text)
                )
        ));
    }

    public static LayoutBlock getSection(String text) {
        return Blocks.section(s ->
                s.text(
                    BlockCompositions.markdownText(text)
                )
        );
    }

    public static LayoutBlock getSection(String text, String imageUrl, String altText) {
        return Blocks.section(s ->
                s.text(
                        BlockCompositions.markdownText(text)
                ).accessory(BlockElements.imageElement(i ->
                        i.imageUrl(imageUrl)
                        .altText(altText)
                ))
        );
    }

    public static LayoutBlock getDivider() {
        return Blocks.divider();
    }
}

