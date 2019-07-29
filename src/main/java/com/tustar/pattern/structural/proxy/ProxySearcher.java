package com.tustar.pattern.structural.proxy;

public class ProxySearcher implements Searcher {

    private RealSearcher searcher = new RealSearcher();
    private AccessValidator validator = new AccessValidator();
    private Logger logger = new Logger();

    public boolean validate(String userId) {
        return validator.validate(userId);
    }

    @Override
    public String doSearch(String userId, String keyword) {
        if (validate(userId)) {
            String result = searcher.doSearch(userId, keyword);
            logger.log(userId);
            return result;
        } else {
            return null;
        }
    }

    public void log(String userId) {
        logger.log(userId);
    }
}
