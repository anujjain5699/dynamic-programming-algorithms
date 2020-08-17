#include<bits/stdc++.h>
using namespace std;
class Node
{
    public :
    int data;
    Node* next;
   
};

void deletePosition(Node** head_ref,int pos)
{
    //linked list empty
    if(*head_ref==NULL)
    return;
    Node* temp=*head_ref;
    if(pos==0)
    {
    *head_ref=temp->next;
    free(temp);
    return;
    }
    for(int i=0;i<pos-1&&temp!=NULL;i++)
    temp=temp->next;
    //if postion is more than number of nodes
    if(temp==NULL||temp->next==NULL)
    return;
    Node* next=temp->next->next;
    free(temp->next);
    temp->next=next;
}

void deleteNode(Node** head_ref,int key)
{
    Node* temp=*head_ref,*prev;
    if(temp!=NULL&& temp->data==key)
    {
        *head_ref=temp->next;
        free(temp);
        return;
    }
    while(temp!=NULL&&temp->data!=key)
    {
        prev=temp;
        temp=temp->next;
    }
    if(temp==NULL)
    return;
    prev->next=temp->next;
    free(temp);

}

void insertAfter(Node* prev_node,int new_data)
{
    Node* new_node=new Node();
    new_node->data=new_data;
    new_node->next=prev_node->next;
    prev_node->next=new_node;
}

void push(Node** head_ref,int new_data)
{
    Node* new_node=new Node();
    new_node->data=new_data;
    new_node->next=(*head_ref);
    (*head_ref)=new_node;
}

void append(Node** head_ref,int new_data)
{
    Node* new_node=new Node();
    Node* last=*head_ref;
    new_node->data=new_data;
    new_node->next=NULL;
    if(*head_ref==NULL)
    {
        *head_ref=new_node;
        return;
    }
    while(last->next!=NULL)
    last=last->next;
    last->next=new_node;
    return ;
}
 void print(Node * n)
    {
        while(n!=NULL)
        {
            cout<<n->data<<" ";
            n=n->next;
        }
    }
    int main()
    {
        Node* head=NULL;
        append(&head,6);
        append(&head,7);
        append(&head,8);
        append(&head,9);
        push(&head,5);
        insertAfter(head->next,10);
        print(head);
        cout<<"\nEnter key for deletion\n";
        int key;
        cin>>key;
        deleteNode(&head,key);
        print(head);
        cout<<"\nEnter postion for deletion:\n";
        int pos;
        cin>>pos;
        deletePosition(&head,pos-1);
         print(head);
        cout<<"\n";
         print(head);
        return 0;
    }