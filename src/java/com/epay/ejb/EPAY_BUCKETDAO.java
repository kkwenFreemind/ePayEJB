package com.epay.ejb;


import com.epay.ejb.bean.EPAY_BUCKET;
import java.util.List;

public interface EPAY_BUCKETDAO {

    public List getAllBucketInfo(String serviceid) throws Exception;
    
    public EPAY_BUCKET getAllBucketInfoByBid(String serviceid,String bucketid) throws Exception;
    
    public boolean insertBucket(EPAY_BUCKET bucket) throws Exception;
    
    public EPAY_BUCKET getBucketByRID(int rid) throws Exception;
    
    public boolean updateBucket(EPAY_BUCKET bucketinfo) throws Exception;
    
    public List ListAllBucketInfo() throws Exception;
    
    
}
