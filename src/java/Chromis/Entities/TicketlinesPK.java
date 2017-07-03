/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chromis.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Asun
 */
@Embeddable
public class TicketlinesPK implements Serializable
{

  @Basic(optional = false)
  @NotNull
  @Size(min = 1, max = 255)
  @Column(name = "ticket")
  private String ticket;
  @Basic(optional = false)
  @NotNull
  @Column(name = "line")
  private int line;

  public TicketlinesPK()
  {
  }

  public TicketlinesPK(String ticket, int line)
  {
    this.ticket = ticket;
    this.line = line;
  }

  public String getTicket()
  {
    return ticket;
  }

  public void setTicket(String ticket)
  {
    this.ticket = ticket;
  }

  public int getLine()
  {
    return line;
  }

  public void setLine(int line)
  {
    this.line = line;
  }

  @Override
  public int hashCode()
  {
    int hash = 0;
    hash += (ticket != null ? ticket.hashCode() : 0);
    hash += (int) line;
    return hash;
  }

  @Override
  public boolean equals(Object object)
  {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof TicketlinesPK))
    {
      return false;
    }
    TicketlinesPK other = (TicketlinesPK) object;
    if ((this.ticket == null && other.ticket != null) || (this.ticket != null && !this.ticket.equals(other.ticket)))
    {
      return false;
    }
    if (this.line != other.line)
    {
      return false;
    }
    return true;
  }

  @Override
  public String toString()
  {
    return "Chromis.Entities.TicketlinesPK[ ticket=" + ticket + ", line=" + line + " ]";
  }
  
}
