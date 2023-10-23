/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epay.ejb.impl;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.epay.ejb.EPAY_COMMON_USERDAO;
import com.epay.ejb.bean.EPAY_COMMON_USER;
//import com.epay.ejb.bean.EPAY_SERVICE_INFO;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author kevinchang
 */
@Stateless
@Local({EPAY_COMMON_USERDAO.class})
public class EPAY_COMMON_USERDAOBean implements EPAY_COMMON_USERDAO {

    private static Logger log = Logger.getLogger(EPAY_COMMON_USERDAOBean.class);

    @PersistenceContext
    protected EntityManager em;

    @Override
    public boolean deleteUser_ByUserId(String userid) throws Exception {
        boolean rtresult = false;
        try {
            Query query = em.createQuery("delete from EPAY_COMMON_USER p  where p.cuser_code='" + userid + "'");
            if (query.executeUpdate() == 1) {
                rtresult = true;
            } else {
                rtresult = false;
            }
        } catch (Exception ex) {
            rtresult = false;
            throw ex;
        }
        return rtresult;
    }

    @Override
    public EPAY_COMMON_USER getAccount_byUserCode(String id) throws Exception {
        Query query = null;
        try {
            query = em.createQuery("select p from EPAY_COMMON_USER p  where p.cuser_code='" + id + "'");

        } catch (NoResultException ex) {
//            throw ex;
        } catch (Exception ex) {
            throw ex;
        }

//        if (query.getSingleResult() != null) {
//            return (PG_COMMON_USER) query.getSingleResult();
//        } else {
//            return null;
//        }
        EPAY_COMMON_USER rtresult = null;
        boolean getresult = false;
        try {
            if (query.getSingleResult() != null) {
                getresult = true;
            } else {
                getresult = false;
            }
        } catch (NoResultException ex) {
//            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
        if (getresult) {
            rtresult = new EPAY_COMMON_USER();
            rtresult = (EPAY_COMMON_USER) query.getSingleResult();
        } else {
            rtresult = null;
        }
        return rtresult;
    }

    @Override
    public String getAccountName_byUserCode(String id) throws Exception {
        Query query = null;
        try {
            query = em.createQuery("select p.CUSER_NAME from EPAY_COMMON_USER p  where p.cuser_code='" + id + "'");

        } catch (Exception ex) {
            throw ex;
        }

//        if (query.getSingleResult() != null) {
//            return (String) query.getSingleResult();
//        } else {
//            return null;
//        }
        String rtresult = null;
        try {

            rtresult = (String) query.getSingleResult();
        } catch (Exception ex) {
            throw ex;
        }
        return rtresult;
    }

    @Override
    public boolean insertAccount(EPAY_COMMON_USER user) throws Exception {
        boolean result = false;
        try {
            em.persist(user);
            result = true;
        } catch (Exception e) {
            result = false;
            throw e;
        }
        return result;
    }

    @Override
    public List getAllUser() throws Exception {
        Query query = null;
        List rtservice = null;
        try {
            query = em.createQuery("select p from EPAY_COMMON_USER p ");

        } catch (NoResultException ex) {
            log.info(ex);
        } catch (Exception ex) {
            log.info(ex);
        }

        rtservice = query.getResultList();

        return rtservice;

    }

    @Override
    public List getUser_ByUserCode(String user_code) throws Exception {
        Query query = null;
        List rtservice = null;
        try {
            query = em.createQuery("select p from EPAY_COMMON_USER p where p.cuser_code = '" + user_code + "' ");
            log.info("select p from EPAY_COMMON_USER p where p.cuser_code = '" + user_code + "' ");
        } catch (NoResultException ex) {
            log.info(ex);
        } catch (Exception ex) {
            log.info(ex);
        }
        rtservice = query.getResultList();
        return rtservice;
    }

    @Override
    public List getUser_ByUserName(String user_name) throws Exception {
        Query query = null;
        List rtservice = null;
        try {
            query = em.createQuery("select p from EPAY_COMMON_USER p where p.cuser_name = '" + user_name + "' ");
        } catch (NoResultException ex) {
            throw new NoResultException();
        } catch (Exception ex) {
            throw ex;
        }
        rtservice = query.getResultList();
        return rtservice;
    }

    @Override
    public List getUser_ByUserMobile(String user_mobile) throws Exception {
        Query query = null;
        List rtservice = null;
        try {
            query = em.createQuery("select p from EPAY_COMMON_USER p where p.cuser_mobile_number = '" + user_mobile + "' ");
        } catch (NoResultException ex) {
            throw new NoResultException();
        } catch (Exception ex) {
            throw ex;
        }
        rtservice = query.getResultList();
        return rtservice;
    }

    @Override
    public List getUser_ByUserRole(String user_role) throws Exception {
        Query query = null;
        List rtservice = null;
        try {
            query = em.createQuery("select p from EPAY_COMMON_USER p left join p.pg_sys_roles a where a.r_id = '" + user_role + "' ");
        } catch (NoResultException ex) {
            throw new NoResultException();
        } catch (Exception ex) {
            throw ex;
        }
        rtservice = query.getResultList();
        return rtservice;
    }

    @Override
    public List getUser_ByUserNameAndUserMobile(String user_name, String user_mobile) throws Exception {
        Query query = null;
        List rtservice = null;
        try {
            query = em.createQuery("select p from EPAY_COMMON_USER p where p.cuser_name = '" + user_name + "' and p.cuser_mobile_number = '" + user_mobile + "' ");
        } catch (NoResultException ex) {
            throw new NoResultException();
        } catch (Exception ex) {
            throw ex;
        }
        rtservice = query.getResultList();
        return rtservice;
    }

    @Override
    public List getUser_ByUserNameAndUserRole(String user_name, String user_role) throws Exception {
        Query query = null;
        List rtservice = null;
        try {
            query = em.createQuery("select p from EPAY_COMMON_USER p left join p.pg_sys_roles a where p.cuser_name = '" + user_name + "' and a.r_id = '" + user_role + "' ");
        } catch (NoResultException ex) {
            throw new NoResultException();
        } catch (Exception ex) {
            throw ex;
        }
        rtservice = query.getResultList();
        return rtservice;
    }

    @Override
    public List getUser_ByUserMobileAndUserRole(String user_mobile, String user_role) throws Exception {
        Query query = null;
        List rtservice = null;
        try {
            query = em.createQuery("select p from EPAY_COMMON_USER p left join p.pg_sys_roles a where  p.cuser_mobile_number = '" + user_mobile + "' and  a.r_id = '" + user_role + "' ");
        } catch (NoResultException ex) {
            throw new NoResultException();
        } catch (Exception ex) {
            throw ex;
        }
        rtservice = query.getResultList();
        return rtservice;
    }

    public List getUser_ByUserNameAndUserMobileAndUserRole(String user_name, String user_mobile, String user_role) throws Exception {
        Query query = null;
        List rtservice = null;
        try {
            query = em.createQuery("select p from EPAY_COMMON_USER p left join p.pg_sys_roles a where  p.cuser_name = '" + user_name + "' and p.cuser_mobile_number = '" + user_mobile + "' and  a.r_id = '" + user_role + "' ");
        } catch (NoResultException ex) {
            throw new NoResultException();
        } catch (Exception ex) {
            throw ex;
        }
        rtservice = query.getResultList();
        return rtservice;
    }

    public boolean updateUser(EPAY_COMMON_USER user) throws Exception {
//        boolean rtresult = false;
//        Query query = null;
//        try {
//            String sql_update = "update PG_COMMON_USER set " +
//                    "cuser_name = '" + user.getCuser_name() + "'," +
//                    "cuser_password='" + user.getCuser_password() + "'," +
//                    "cuser_mobile_number='" + user.getCuser_mobile_number() + "'," +
//                    "cuser_email='" + user.getCuser_email() + "'," +
//                    "cuser_status='" + user.getCuser_status() + "'," +
//                    "pg_sys_roles='" + user.getPg_sys_roles().getR_id() + "' " +
//                    "where cuser_code = '" + user.getCuser_code() + "'";
//            System.out.println("@@@@@@sql_update:"+sql_update);
//            query = em.createQuery(sql_update);
//            if (query.executeUpdate() == 1) {
//                rtresult = true;
//            } else {
//                rtresult = false;
//            }
//        } catch (Exception ex) {
//            rtresult = true;
//            throw ex;
//        }
//        return rtresult;

        boolean result = false;

        try {
            em.merge(user);
            result = true;
        } catch (Exception e) {
            result = false;
            throw e;
        }
        return result;
    }
}
