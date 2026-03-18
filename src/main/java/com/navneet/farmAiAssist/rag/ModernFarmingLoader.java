package com.navneet.farmAiAssist.rag;

import jakarta.annotation.PostConstruct;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.tika.TikaDocumentReader;
import org.springframework.ai.transformer.splitter.TextSplitter;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ModernFarmingLoader {

    private final VectorStore vectorStore;

    @Value("classpath:Doc_RAG_testing.pdf")
    Resource modernFarming;

    public ModernFarmingLoader(VectorStore vectorStore){
        this.vectorStore = vectorStore;
    }

    @PostConstruct
    public void loadPDF(){
        TikaDocumentReader tikaDocumentReader = new TikaDocumentReader(modernFarming);
        List<Document> docs = tikaDocumentReader.get();
        TextSplitter textSplitter = TokenTextSplitter.builder().withChunkSize(200).withMaxNumChunks(500).build();
        vectorStore.add(textSplitter.split(docs));
        vectorStore.add(docs);
    }

}
