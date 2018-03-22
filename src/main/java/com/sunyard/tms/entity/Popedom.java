package com.sunyard.tms.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.common.base.Strings;
import com.sunyard.tms.constant.StatusConstants;

public class Popedom implements Serializable {
    private String popedomId;

    private String popedomName;
    @JSONField(serialize=false)
    private String popedomAction;
    @JSONField(serialize=false)
    private String popedomType;

    private String popedomRemark;

    private String popedomPid;
    @JSONField(serialize=false)
    private String bak1;
    @JSONField(serialize=false)
    private String bak2;
    @JSONField(serialize=false)
    private String bak3;

    private String popedomLink;

    private String popedomIconcls;
    @JSONField(serialize=false)
    private String popedomOrigin;

    private static final long serialVersionUID = 1L;
    
    // --以下字段为过程中使用---//
    
    private String popedomTypeName;
    
    /**
	 * 子权限
	 */
	private List<Popedom> children = new ArrayList<Popedom>();

	private List<String> ids = new ArrayList<>();

    public String getPopedomId() {
        return popedomId;
    }

    public void setPopedomId(String popedomId) {
        this.popedomId = popedomId == null ? null : popedomId.trim();
    }

    public String getPopedomName() {
        return popedomName;
    }

    public void setPopedomName(String popedomName) {
        this.popedomName = popedomName == null ? null : popedomName.trim();
    }

    public String getPopedomAction() {
        return popedomAction;
    }

    public void setPopedomAction(String popedomAction) {
        this.popedomAction = popedomAction == null ? null : popedomAction.trim();
    }

    public String getPopedomType() {
        return popedomType;
    }

    public void setPopedomType(String popedomType) {
        this.popedomType = popedomType == null ? null : popedomType.trim();
    }

    public String getPopedomRemark() {
        return popedomRemark;
    }

    public void setPopedomRemark(String popedomRemark) {
        this.popedomRemark = popedomRemark == null ? null : popedomRemark.trim();
    }

    public String getPopedomPid() {
        return popedomPid;
    }

    public void setPopedomPid(String popedomPid) {
        this.popedomPid = popedomPid == null ? null : popedomPid.trim();
    }

    public String getBak1() {
        return bak1;
    }

    public void setBak1(String bak1) {
        this.bak1 = bak1 == null ? null : bak1.trim();
    }

    public String getBak2() {
        return bak2;
    }

    public void setBak2(String bak2) {
        this.bak2 = bak2 == null ? null : bak2.trim();
    }

    public String getBak3() {
        return bak3;
    }

    public void setBak3(String bak3) {
        this.bak3 = bak3 == null ? null : bak3.trim();
    }

    public String getPopedomLink() {
        return popedomLink;
    }

    public void setPopedomLink(String popedomLink) {
        this.popedomLink = popedomLink == null ? null : popedomLink.trim();
    }

    public String getPopedomIconcls() {
        return popedomIconcls;
    }

    public void setPopedomIconcls(String popedomIconcls) {
        this.popedomIconcls = popedomIconcls == null ? null : popedomIconcls.trim();
    }

    public String getPopedomOrigin() {
        return popedomOrigin;
    }

    public void setPopedomOrigin(String popedomOrigin) {
        this.popedomOrigin = popedomOrigin == null ? null : popedomOrigin.trim();
    }
    
    public List<Popedom> getChildren() {
		return children;
	}

	public void setChildren(List<Popedom> children) {
		this.children = children;
	}

	public String getPopedomTypeName() {
		if (!Strings.isNullOrEmpty(popedomType)) {
			if(popedomType.equals(StatusConstants.POPEDOM_LIST)){
	            return "menu popedom";
	        }else if(popedomType.equals(StatusConstants.POPEDOM_BUTTON)){
	            return "button popedom";
	        }else {
	            return "other";
	        }  
		} else {
			return popedomTypeName;
		}
	}

	public void setPopedomTypeName(String popedomTypeName) {
		this.popedomTypeName = popedomTypeName;
	}
    
    @Override
    public String toString() {
        return "Popedom [popedomId=" + popedomId + ", popedomName=" + popedomName + ", popedomAction=" + popedomAction
                + ", popedomType=" + popedomType + ", popedomTypeName=" + popedomTypeName + ", popedomRemark="
                + popedomRemark + ", popedomPid=" + popedomPid + ", popedomLink=" + popedomLink + ", popedomIconcls="
                + popedomIconcls + ", popedomOrigin=" + popedomOrigin + ", bak1=" + bak1 + ", bak2=" + bak2 + ", bak3=" + bak3
                + ", children=" + children + "]";
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bak1 == null) ? 0 : bak1.hashCode());
        result = prime * result + ((bak2 == null) ? 0 : bak2.hashCode());
        result = prime * result + ((bak3 == null) ? 0 : bak3.hashCode());
        result = prime * result + ((children == null) ? 0 : children.hashCode());
        result = prime * result + ((popedomAction == null) ? 0 : popedomAction.hashCode());
        result = prime * result + ((popedomIconcls == null) ? 0 : popedomIconcls.hashCode());
        result = prime * result + ((popedomId == null) ? 0 : popedomId.hashCode());
        result = prime * result + ((popedomLink == null) ? 0 : popedomLink.hashCode());
        result = prime * result + ((popedomName == null) ? 0 : popedomName.hashCode());
        result = prime * result + ((popedomOrigin == null) ? 0 : popedomOrigin.hashCode());
        result = prime * result + ((popedomPid == null) ? 0 : popedomPid.hashCode());
        result = prime * result + ((popedomRemark == null) ? 0 : popedomRemark.hashCode());
        result = prime * result + ((popedomType == null) ? 0 : popedomType.hashCode());
        result = prime * result + ((popedomTypeName == null) ? 0 : popedomTypeName.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Popedom other = (Popedom) obj;
        if (bak1 == null) {
            if (other.bak1 != null) {
                return false;
            }
        } else if (!bak1.equals(other.bak1)) {
            return false;
        }
        if (bak2 == null) {
            if (other.bak2 != null) {
                return false;
            }
        } else if (!bak2.equals(other.bak2)) {
            return false;
        }
        if (bak3 == null) {
            if (other.bak3 != null) {
                return false;
            }
        } else if (!bak3.equals(other.bak3)) {
            return false;
        }
        if (children == null) {
            if (other.children != null) {
                return false;
            }
        } else if (!children.equals(other.children)) {
            return false;
        }
        if (popedomAction == null) {
            if (other.popedomAction != null) {
                return false;
            }
        } else if (!popedomAction.equals(other.popedomAction)) {
            return false;
        }
        if (popedomIconcls == null) {
            if (other.popedomIconcls != null) {
                return false;
            }
        } else if (!popedomIconcls.equals(other.popedomIconcls)) {
            return false;
        }
        if (popedomId == null) {
            if (other.popedomId != null) {
                return false;
            }
        } else if (!popedomId.equals(other.popedomId)) {
            return false;
        }
        if (popedomLink == null) {
            if (other.popedomLink != null) {
                return false;
            }
        } else if (!popedomLink.equals(other.popedomLink)) {
            return false;
        }
        if (popedomName == null) {
            if (other.popedomName != null) {
                return false;
            }
        } else if (!popedomName.equals(other.popedomName)) {
            return false;
        }
        if (popedomOrigin == null) {
            if (other.popedomOrigin != null) {
                return false;
            }
        } else if (!popedomOrigin.equals(other.popedomOrigin)) {
            return false;
        }
        if (popedomPid == null) {
            if (other.popedomPid != null) {
                return false;
            }
        } else if (!popedomPid.equals(other.popedomPid)) {
            return false;
        }
        if (popedomRemark == null) {
            if (other.popedomRemark != null) {
                return false;
            }
        } else if (!popedomRemark.equals(other.popedomRemark)) {
            return false;
        }
        if (popedomType == null) {
            if (other.popedomType != null) {
                return false;
            }
        } else if (!popedomType.equals(other.popedomType)) {
            return false;
        }
        if (popedomTypeName == null) {
            if (other.popedomTypeName != null) {
                return false;
            }
        } else if (!popedomTypeName.equals(other.popedomTypeName)) {
            return false;
        }
        return true;
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }
}