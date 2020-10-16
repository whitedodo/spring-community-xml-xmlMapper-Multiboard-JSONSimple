package com.community.website.logic;

public class Paging {
	
    private long pageSize; 			// 게시 글 수
    private long firstPageNo; 		// 첫 번째 페이지 번호
    private long prevPageNo; 		// 이전 페이지 번호
    private long startPageNo; 		// 시작 페이지 (페이징 네비 기준)
    private long pageNo; 			// 페이지 번호
    private long endPageNo; 		// 끝 페이지 (페이징 네비 기준)
    private long nextPageNo; 		// 다음 페이지 번호
    private long finalPageNo; 		// 마지막 페이지 번호
    private long totalCount; 		// 게시 글 전체 수
    private long dbStartNum;		// db 조회 (시작번호)
    private long dbEndNum;			// db 조회 (종료번호)

    /**
     * @return the pageSize
     */
    public long getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return the firstPageNo
     */
    public long getFirstPageNo() {
        return firstPageNo;
    }

    /**
     * @param firstPageNo the firstPageNo to set
     */
    public void setFirstPageNo(long firstPageNo) {
        this.firstPageNo = firstPageNo;
    }

    /**
     * @return the prevPageNo
     */
    public long getPrevPageNo() {
        return prevPageNo;
    }

    /**
     * @param prevPageNo the prevPageNo to set
     */
    public void setPrevPageNo(long prevPageNo) {
        this.prevPageNo = prevPageNo;
    }

    /**
     * @return the startPageNo
     */
    public long getStartPageNo() {
        return startPageNo;
    }

    /**
     * @param startPageNo the startPageNo to set
     */
    public void setStartPageNo(long startPageNo) {
        this.startPageNo = startPageNo;
    }

    /**
     * @return the pageNo
     */
    public long getPageNo() {
        return pageNo;
    }

    /**
     * @param pageNo the pageNo to set
     */
    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
    }

    /**
     * @return the endPageNo
     */
    public long getEndPageNo() {
        return endPageNo;
    }

    /**
     * @param endPageNo the endPageNo to set
     */
    public void setEndPageNo(long endPageNo) {
        this.endPageNo = endPageNo;
    }

    /**
     * @return the nextPageNo
     */
    public long getNextPageNo() {
        return nextPageNo;
    }

    /**
     * @param nextPageNo the nextPageNo to set
     */
    public void setNextPageNo(long nextPageNo) {
        this.nextPageNo = nextPageNo;
    }

    /**
     * @return the finalPageNo
     */
    public long getFinalPageNo() {
        return finalPageNo;
    }

    /**
     * @param finalPageNo the finalPageNo to set
     */
    public void setFinalPageNo(long finalPageNo) {
        this.finalPageNo = finalPageNo;
    }

    /**
     * @return the totalCount
     */
    public long getTotalCount() {
        return totalCount;
    }

    /**
     * @param totalCount the totalCount to set
     */
    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
        this.makePaging();
        this.makeDbPaging();
    }

    /**
     * 페이징 생성 (setTotalCount에서 호출함)
     */
    private void makePaging() {
    	
        if (this.totalCount == 0) 
        	return; 
        
        // 게시 글 전체 수가 없는 경우
        
        if (this.pageNo == 0) 
        	this.setPageNo(1); // 기본 값 설정
        
        if (this.pageSize == 0) 
        	this.setPageSize(10); // 기본 값 설정

        long finalPage = (totalCount + (pageSize - 1)) / pageSize; // 마지막 페이지
        
        if (this.pageNo > finalPage) 
        	this.setPageNo(finalPage); // 기본 값 설정

        if (this.pageNo < 0 || this.pageNo > finalPage) 
        	this.pageNo = 1; // 현재 페이지 유효성 체크

        boolean isNowFirst = pageNo == 1 ? true : false; // 시작 페이지 (전체)
        boolean isNowFinal = pageNo == finalPage ? true : false; // 마지막 페이지 (전체)

        long startPage = ((pageNo - 1) / 10) * 10 + 1; // 시작 페이지 (페이징 네비 기준)
        long endPage = startPage + 10 - 1; // 끝 페이지 (페이징 네비 기준)

        if (endPage > finalPage) { // [마지막 페이지 (페이징 네비 기준) > 마지막 페이지] 보다 큰 경우
            endPage = finalPage;
        }

        this.setFirstPageNo(1); // 첫 번째 페이지 번호

        if (isNowFirst) {
            this.setPrevPageNo(1); 									   // 이전 페이지 번호
        } else {
            this.setPrevPageNo(((pageNo - 1) < 1 ? 1 : (pageNo - 1))); // 이전 페이지 번호
        }

        this.setStartPageNo(startPage); // 시작 페이지 (페이징 네비 기준)
        this.setEndPageNo(endPage); // 끝 페이지 (페이징 네비 기준)

        if (isNowFinal) {
            this.setNextPageNo(finalPage); // 다음 페이지 번호
        } else {
            this.setNextPageNo(((pageNo + 1) > finalPage ? finalPage : (pageNo + 1))); // 다음 페이지 번호
        }

        this.setFinalPageNo(finalPage); // 마지막 페이지 번호
        
    }
    
    private void makeDbPaging() {
    	
    	long current = this.getPageNo();
    	long weight = this.getPageSize();
    	long endNum = 0;
    	
    	this.setDbEndNum( current * weight );
    	
    	endNum = this.getDbEndNum();
    	this.setDbStartNum( (endNum - weight) + 1 );
    	
    }

    /**
     * @return the dbStartNum
     */
	public long getDbStartNum() {
		return dbStartNum;
	}

    /**
     * @param dbStartNum the dbStartNum to set
     */
	public void setDbStartNum(long dbStartNum) {
		this.dbStartNum = dbStartNum;
	}
	
    /**
     * @return dbEndNum
     */
	public long getDbEndNum() {
		return dbEndNum;
	}

    /**
     * @param dbEndNum the dbEndNum to set
     */
	public void setDbEndNum(long dbEndNum) {
		this.dbEndNum = dbEndNum;
	}
    
}